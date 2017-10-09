# Awexa - Alexa skill

## Setup
1. `pip install virtualenv`
2. `virtualenv venv`
    + If you're using Windows and get `virtualenv: command not found`, but when you try to `pip install virtualenv`, it says `Requirement already satisfied: virtualenv in path\to\installation`, you can go to that path, and run `python virtualenv.py --distribute \path\to\thisrepo\venv` to get it to work. 
3. Activate the virtual environment: `\. venv\bin\activate`
    + In Windows it will be in `.\venv\Scripts\activate`
4. Deactivate the virtual environment `deactivate` 
    + In Windows it will be in `.\venv\Scripts\deactivate.bat`
5. Install the requirements `pip install -r requirements.txt` with the virtual environment activated

## Setting Up Alexa Skill in the Developer Console
1. Interaction Model:
    + current intent schema is in speech-assets\intent\_schema.json
    + current sample_utterances is in speech-assets\sample\_utterances.txt
2. Configuration
    + Service Endpoint Type: https
    + region: NA
    + service endpoint link: <null>
3. SSL Certificate
    + <null>