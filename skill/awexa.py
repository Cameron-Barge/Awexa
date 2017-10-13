import logging
import requests
from flask import Flask
from flask_ask import Ask, statement

ENDPOINT = ''  # TODO
app = Flask(__name__)
ask = Ask(app, '/')


@ask.launch
def launch():
    return statement("Hello, how can I help you today?")


@ask.intent("GetChoresIntent")
def getChores(child_name):
    # r = requests.get(ENDPOINT)
    # chore_json = r.json()
    chore_json = {
        'chores': [
            {
                'name': 'Wash dishes',
                'reward': '1 hour screen time'
            },
            {
                'name': 'Make bed',
                'reward': 'Popcorn'
            }
        ]
    }

    if True:  # r.status_code == 200:
        return statement("{} has {} chores.".format(child_name, len(chore_json['chores'])))
    else:
        message = chore_json['message']
        speech = "There was a problem accessing the database."

    logger.info('speech = {}'.format(speech))
    return statement(speech)


@ask.intent("GetRewardsIntent")
def getRewards(child_name):
    # r = requests.get(ENDPOINT)
    # rewards = r.json()
    rewards = {
        'rewards': [
            {
                'name': 'Wash dishes',
                'reward': '1 hour screen time'
            },
            {
                'name': 'Make bed',
                'reward': 'Popcorn'
            }
        ]
    }

    if True:  # r.status_code == 200:
        return statement("{} has {} rewards.".format(child_name, len(rewards['rewards'])))
    else:
        message = rewards['message']
        speech = "There was a problem accessing the database."

    logger.info('speech = {}'.format(speech))
    return statement(speech)