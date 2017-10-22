import difflib
import logging
import requests
from flask import Flask
from flask_ask import Ask, statement


ENDPOINT = 'https://awexa-4bad0.firebaseio.com/'
DEVICE_ENDPOINT = ENDPOINT + 'deviceToFamily/'
FAMILY_ENDPOINT = ENDPOINT + 'families/'
CHILD_ENDPOINT = ENDPOINT + 'children/'
CHORES_ENDPOINT = ENDPOINT + 'chores/'
REWARDS_ENDPOINT = ENDPOINT + 'rewards/'

device_id = 'deviceid1'  # TODO: get actual device ID
logger = logging.getLogger()

app = Flask(__name__)
ask = Ask(app, '/')


@ask.launch
def launch():
    return statement("Hello, how can I help you today?")


@ask.intent("GetChoresIntent")
def getChores(child_name):
    # get family_id from device_id
    r = requests.get(DEVICE_ENDPOINT + device_id + ".json")
    if r.status_code != 200:
        return statement(handleConnectionError(r))
    if r.content == "null":
        return statement(handleUnregisteredDevice(device_id))
    family_id = r.content.replace('"', '')

    # get family_json from family_id
    r = requests.get(FAMILY_ENDPOINT + family_id + ".json")
    if r.status_code != 200:
        return statement(handleConnectionError(r))
    family_json = r.json()

    # get child_id from family_json[child_name]
    child_id = ''
    try:
        child_id = family_json['child_names'][child_name.title()]
    except KeyError:
        return statement(handleNoChildError(child_name, family_json))

    # get list(chore_ids) from children table
    r = requests.get(CHILD_ENDPOINT + child_id + ".json")
    if r.status_code != 200:
        return statement(handleConnectionError(r))
    child_json = r.json()
    chore_id_list = [chore for chore,flag in child_json['chores'].iteritems() if flag]

    # get list(chore_info) from list(chore_ids)
    chores = []
    for chore_id in chore_id_list:
        r = requests.get(CHORES_ENDPOINT + chore_id + ".json")
        if r.status_code != 200:
            return statement(handleConnectionError(r))
        chore_json = r.json()
        chores.append("{} for {} points".format(chore_json['name'], chore_json['points']))

    # return speechlet
    return statement("{} has {} chores: {}"
                        .format(child_name, len(chores), listToAndString(chores)))


@ask.intent("GetRewardsIntent")
def getRewards(child_name):
    r = requests.get(ENDPOINT + device_id)
    family_json = r.json()

    if r.status_code == 200 and family_json is not None:
        child_chores = getChildsChores(family_json, child_name)
        rewards = [family_json['chores'][str(c)]['rewardId'] for c in child_chores]
        reward_list = [family_json['rewards'][r]['name'] for r in rewards]
        return statement("{} has {} rewards: {}"
                        .format(child_name, len(reward_list), listToAndString(reward_list)))
    else:
        return statement(handleError(r))


@ask.intent("FinishChoreIntent")
def finishChore(child_name, chore):
    r = requests.get(ENDPOINT + device_id)
    family_json = r.json()

    if r.status_code == 200 and family_json is not None:
        child_chores = family_json['children'][child_name.title()]['chores'].split(',')
        chores = [family_json['chores'][str(c)]['name'] for c in child_chores]

        # find closest chore from list, with similarity of >= 0.6
        guess = difflib.get_close_matches(chore, chores)

        logger.info(guess)

        if guess == []:
            return statement("Sorry, I didn't understand. Please state a chore from this list: {}"
                            .format(listToAndString(chores)))

        return statement("Bobby finished the chore: {}".format(guess[0]))
    else:
        return statement(handleError(r))


def getChildsChores(family_json, child_name):
    return family_json['children'][child_name.title()]['chores'].split(',')


def listToAndString(itemList):
    if len(itemList) > 1:
        return ', '.join(itemList[:-1]) + ', and ' + itemList[-1]
    elif len(itemList) == 1:
        return itemList[0]
    else:  # len(itemList) < 1
        return ""


def handleConnectionError(response):
    speech = "There was a problem accessing the database."
    logger.info('speech = {}'.format(speech))
    logger.info('response = {}'.format(response.content))
    return speech


def handleNoChildError(child_name, family_json):
    speech = "There was no child found for this family named {}. ".format(child_name)
    children = [key for key, value in family_json['child_names']]
    speech += " Please add a child using the app or choose from these children: {}".format(children)
    return speech


def main():  # test cases pre-zappa deployment
    print getChores('Bobby')
    print getRewards('Bobby')
    print finishChore('Bobby', 'taking out the trash')  # similar enough
    print finishChore('Bobby', 'mow the lawn')  # not similar enough


if __name__ == '__main__':
    main()
