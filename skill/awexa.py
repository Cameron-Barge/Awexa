import difflib
import logging
import requests
from flask import Flask
from flask_ask import Ask, question, session, statement


ENDPOINT = 'https://awexa-4bad0.firebaseio.com/'

STATE_ATTRIBUTE = 'STATE_ATTRIBUTE'
# list of states (enum)
NONE = 'none'
CHORES = 'get_chores'
REWARDS = 'get_rewards'
FINISH = 'finish_chores'
BUY = 'buy_reward'

logger = logging.getLogger()

app = Flask(__name__)
ask = Ask(app, '/')


@ask.launch
def launch():
    set_state(NONE)
    return question("Hello, how can I help you today?") \
        .reprompt("I missed that. How can I help you today?")


@ask.intent("LinkAccountIntent")
def linkAccount(code):
    if linked():
        return getReprompt(
            question("This device is already linked to an account"))

    if code is None:  # TODO: Fix this, only problem if is in emulator
        code = "1234"

    r = requests.get(link_endpoint(code))
    if r.status_code != 200:
        return statement(handleConnectionError(r))
    if r.content == "null":
        return question("{} is an incorrect code.".format(code)) \
            .reprompt("Please retry using our app.")
    family_id = r.content

    r = requests.put(device_endpoint(user_id()), data=family_id)
    if r.status_code != 200:
        return statement(handleConnectionError(r))
    else:
        return getReprompt(
            question("I linked this device! You can now start using Awexa."))


@ask.intent("GetChoresIntent")
def getChores(child_name):
    return_val = getChild(child_name)
    if isinstance(return_val, statement):
        return return_val
    if isinstance(return_val, question):
        set_state(CHORES)
        return return_val

    child_json = return_val[0]

    # get list(chore_id) from child_json
    chore_id_list = getChoreIdList(child_json)

    # get list(chore_info) from list(chore_ids)
    chores = []
    for chore_id in chore_id_list:
        r = requests.get(chores_endpoint(chore_id))
        if r.status_code != 200:
            return statement(handleConnectionError(r))
        chore_json = r.json()
        chores.append("{} for {} points"
                      .format(chore_json['name'], chore_json['points']))

    # return speechlet
    num = str(len(chores)) + (" chores" if len(chores) != 1 else " chore")
    return getReprompt(
        question("You have {} : {}".format(num, listToAndString(chores))))


@ask.intent("GetRewardsIntent")
def getRewards(child_name):
    return_val = getChild(child_name)
    if isinstance(return_val, statement):
        return return_val
    if isinstance(return_val, question):
        set_state(REWARDS)
        return return_val

    child_json = return_val[0]
    points = child_json['points']

    # get list(reward_id) from child_json
    reward_id_list = [reward for reward in child_json['rewards']]

    # get list(reward_info) from list(reward_ids)
    rewards = []
    for reward_id in reward_id_list:
        r = requests.get(rewards_endpoint(reward_id))
        if r.status_code != 200:
            return statement(handleConnectionError(r))
        r_json = r.json()
        rewards.append("{} for {} points".format(r_json['name'],
                                                 r_json['points']))

    # return speechlet
    point_num_phrase = str(points) + (" points" if points != 1 else " point")
    reward_num_phrase = str(len(rewards)) \
        + (" rewards" if len(rewards) != 1 else " reward")
    return getReprompt(question("You have {}, applicable to {}: {}"
                                .format(point_num_phrase, reward_num_phrase,
                                        listToAndString(rewards))))


@ask.intent("FinishChoreIntent")
def finishChore(child_name, chore):
    return_val = getChild(child_name)
    if isinstance(return_val, statement):
        return return_val
    if isinstance(return_val, question):
        set_state(FINISH)
        set_saved_chore(chore)
        return return_val

    child_json, child_id = return_val

    # get list(chore_id) from child_json
    chore_id_list = getChoreIdList(child_json)

    # get list(chore_name) from list(chore_ids)
    chores = {}
    for chore_id in chore_id_list:
        r = requests.get(chores_endpoint(chore_id, "/name"))
        if r.status_code != 200:
            return statement(handleConnectionError(r))
        chores[r.content.replace('"', '').lower()] = chore_id

    # find closest chore from list, with similarity of >= 0.6
    guess = difflib.get_close_matches(chore, chores.keys())

    try:
        guess = guess[0]
        r = requests.put(child_endpoint(child_id, "/chores/" + chores[guess]),
                         data='"completed"')
        if r.status_code != 200:
            return statement(handleConnectionError(r))
        else:
            return getReprompt(
                question("I marked {} as finishing the chore: {}"
                         .format(child_json['name'], guess)))
    except IndexError:
        if chores.keys() == []:
            return getReprompt(
                question("{} has no chores.".format(child_name)))
        return getReprompt(question(
            "Sorry I couldn't find that chore. Pick a chore from this list: {}"
            .format(listToAndString(chores.keys()))))


@ask.intent("BuyRewardIntent")
def buyReward(child_name, reward):
    return_val = getChild(child_name)
    if isinstance(return_val, statement):
        return return_val
    if isinstance(return_val, question):
        set_state(BUY)
        set_saved_reward(reward)
        return return_val

    child_json, child_id = return_val
    points = child_json['points']

    # get list(reward_id) from child_json
    reward_id_list = [rew for rew in child_json['rewards']]

    # get list(reward_info) from list(reward_ids)
    rewards = {}
    for reward_id in reward_id_list:
        r = requests.get(rewards_endpoint(reward_id))
        if r.status_code != 200:
            return statement(handleConnectionError(r))

        rew = r.json()
        rewards[rew['name']] = (reward_id, rew['points'])

    # find closest reward from list, with similarity of >= 0.6
    guess = difflib.get_close_matches(reward, rewards.keys())

    try:
        guess = guess[0]
        cost = rewards[guess][1]

        # check the child has sufficient points
        if points < cost:
            pts_phrase = str(points) + (" points" if points != 1 else " point")
            cost_phrase = str(cost) + (" points" if cost != 1 else " point")
            return getReprompt(
                question("You only have {}, not enough to buy {}, which "
                         "costs {}".format(pts_phrase, guess, cost_phrase)))

        # update a child's count of the reward
        reward_id = rewards[guess][0]
        r = requests.put(child_endpoint(child_id, "/rewards/" + reward_id),
                         data=str(child_json['rewards'][reward_id] + 1))
        if r.status_code != 200:
            return statement(handleConnectionError(r))
        else:
            return getReprompt(question("{} bought the reward: {}"
                                        .format(child_json['name'], guess)))
    except IndexError:
        if rewards.keys() == []:
            return getReprompt(
                question("{} has no available rewards.".format(child_name)))
        return getReprompt(question(
            "Sorry I couldn't find that reward. Pick one from this list: {}"
            .format(listToAndString(rewards.keys()))))


@ask.intent("GetNameIntent")
def getName(child_name):
    response = None
    if get_state() == CHORES:
        response = getChores(child_name)
    elif get_state() == REWARDS:
        response = getRewards(child_name)
    elif get_state() == FINISH:
        response = finishChore(child_name, get_saved_chore())
        set_saved_chore(None)
    elif get_state() == BUY:
        response = buyReward(child_name, get_saved_reward())
        set_saved_reward(None)
    else:
        response = launch()

    set_state(NONE)
    return response


@ask.intent("AMAZON.RepeatIntent")
def repeat():
    if get_state() == NONE:
        return launch()
    else:
        return question("What's your name?") \
            .reprompt("I need to know your name to finish this action.")


@ask.intent("AMAZON.HelpIntent")
def help():
    if get_state() == NONE:
        return question("Ask me about your chores and rewards. "
                        "You can also tell me if you finished a chore. "
                        "Or I can help you buy a reward!")
    else:
        return question("What's your name?") \
            .reprompt("I need to know your name to finish this action.")


@ask.intent("AMAZON.StopIntent")
def stop():
    cancel()
    return statement("Bye now!")


@ask.intent("AMAZON.CancelIntent")
def cancel():
    set_state(NONE)
    set_saved_chore(None)
    return getReprompt(question("I canceled your action!"))


#### HELPERS ####
def get_state():
    return session.attributes.get(STATE_ATTRIBUTE)


def set_state(state):
    session.attributes[STATE_ATTRIBUTE] = state


def get_saved_chore():
    return session.attributes.get('chore')


def set_saved_chore(chore):
    session.attributes['chore'] = chore


def get_saved_reward():
    return session.attributes.get('reward')


def set_saved_reward(reward):
    session.attributes['reward'] = reward


def user_id():
    # user id contains periods (problem bc url), so get the unique last quartet
    return session.user.userId.split('.')[-1]


def linked():
    r = requests.get(device_endpoint(user_id()))
    if r.status_code != 200:
        return statement(handleConnectionError(r))

    return r.content != "null"  # True = linked, False = not linked


def getReprompt(q):
    return q.reprompt("Ask for help to see what Awexa can do for you!")


def getChoreIdList(child_json):
    # get list(chore_id) from child_json
    return [c for c, flag in child_json['chores'].iteritems()
            if flag == "assigned"]


def getChild(child_name):
    # get family_id from user_id
    r = requests.get(device_endpoint(user_id()))
    if r.status_code != 200:
        return statement(handleConnectionError(r))
    if r.content == "null":
        return handleUnregisteredDevice()
    family_id = r.content.replace('"', '')

    # get family_json from family_id
    r = requests.get(family_endpoint(family_id, '/child_names'))
    if r.status_code != 200:
        return statement(handleConnectionError(r))
    family_json = r.json()

    # get child_id from family_json[child_name]
    child_id = ''
    try:
        child_id = family_json[child_name.title()]
    except AttributeError:  # child_name is None
        if len(family_json) == 1:
            child_id = family_json.values()[0]
        else:
            return question("What's your name?")
    except KeyError:
        return statement(handleNoChildError(child_name, family_json))

    # get child from children table
    r = requests.get(child_endpoint(child_id))
    if r.status_code != 200:
        return statement(handleConnectionError(r))
    return (r.json(), child_id)


def listToAndString(itemList):
    if len(itemList) > 1:
        return ', '.join(itemList[:-1]) + ', and ' + itemList[-1]
    elif len(itemList) == 1:
        return itemList[0]
    else:  # len(itemList) < 1
        return ""


#### ERROR HANDLING ####
def handleConnectionError(response):
    speech = "There was a problem accessing the database."
    logger.info('speech = {}'.format(speech))
    logger.debug('response = {}'.format(response.content))
    print speech
    return speech


def handleNoChildError(child_name, family_json):
    speech = "There was no child found for this family named " + child_name
    children = [key for key, value in family_json.iteritems()]
    speech += " Add a child with the site or app, or select from these: "
    speech += listToAndString(children)
    print speech
    return speech


def handleUnregisteredDevice():
    return question("Please link this device to your family's Awexa account. "
                    "What is your linking code?") \
        .reprompt("Please tell me your linking code to set up this device.")


#### ENDPOINT URL BUILDERS ####
def link_endpoint(code):
    return ENDPOINT + 'codeToFamily/' + code + '.json'


def device_endpoint(device_id):
    return ENDPOINT + 'deviceToFamily/' + device_id + '.json'


def family_endpoint(family_id, path=''):
    return ENDPOINT + 'families/' + family_id + path + '.json'


def child_endpoint(child_id, path=''):
    return ENDPOINT + 'children/' + child_id + path + '.json'


def chores_endpoint(chore_id, path=''):
    return ENDPOINT + 'chores/' + chore_id + path + '.json'


def rewards_endpoint(reward_id, path=''):
    return ENDPOINT + 'rewards/' + reward_id + path + '.json'


#### MAIN ####
def main():  # test cases pre-zappa deployment
    print getChores('Drew')  # should return chores
    print getChores('FakeChild')  # should return error
    print getRewards('Drew')
    print finishChore('Drew', 'taking out the trash')  # similar enough
    print finishChore('Drew', 'mow the lawn')  # not similar enough
    print buyReward('Drew', 'cake')


if __name__ == '__main__':
    main()
