import logging
from flask import Flask, render_template
from flast_ask import Ask, statement, question, session

logger = logging.getLogger()

app = Flask(__name__)
ask = Ask(app, "/")

@ask.intent('HelloIntent')
def hello(firstname):
    speech_text = "Hello %s" % firstname
    return statement(speech_text).simple_card('Hello', speech_text)

if __name__ == '__main__':
    app.run()