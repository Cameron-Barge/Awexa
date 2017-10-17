import logging
import requests
from flask import Flask
from flask_ask import Ask, statement

ENDPOINT = 'https://awexa-4bad0.firebaseio.com/families/'
device_id = 'family1.json'  # TODO: get actual device ID

app = Flask(__name__)
ask = Ask(app, '/')


@ask.launch
def launch():
    return statement("Hello, how can I help you today?")


@ask.intent("GetChoresIntent")
def getChores(child_name):
    r = requests.get(ENDPOINT + device_id)
    family_json = r.json()

    if r.status_code == 200 and family_json is not None:
        child_chores = family_json['children'][child_name.title()]['chores'].split(',')
        chores = [family_json['chores'][str(c)]['name'] for c in child_chores]
        return statement("{} has {} chores: {}".format(child_name, len(chores), listToAndString(chores)))
    else:
        speech = "There was a problem accessing the database."
        logger.info('speech = {}'.format(speech))
        return statement(speech)


@ask.intent("GetRewardsIntent")
def getRewards(child_name):
    r = requests.get(ENDPOINT + device_id)
    family_json = r.json()

    if r.status_code == 200 and family_json is not None:
        child_chores = family_json['children'][child_name.title()]['chores'].split(',')
        rewards = [family_json['chores'][str(c)]['rewardId'] for c in child_chores]
        reward_list = [family_json['rewards'][r]['name'] for r in rewards]
        return statement("{} has {} rewards: {}".format(child_name, len(reward_list), listToAndString(reward_list)))
    else:
        return statement(handleError(r))


def listToAndString(itemList):
    if len(itemList) > 1:
        return ', '.join(itemList[:-1]) + ', and ' + itemList[-1]
    elif len(itemList) == 1:
        return itemList[0]
    else:  # len(itemList) < 1
        return ""


def handleError(response):
    speech = "There was a problem accessing the database."
    logger.info('speech = {}'.format(speech))
    logger.info('response = {}'.format(response.content))
    return speech
