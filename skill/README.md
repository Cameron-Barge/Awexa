
# Awexa : the Alexa skill part

## Setup
1. `pip install virtualenv`
2. `virtualenv venv`
    + If you're using Windows and get `virtualenv: command not found`, but when you try to `pip install virtualenv`, it says `Requirement already satisfied: virtualenv in path\to\installation`, you can go to that path, and run `python virtualenv.py --distribute \path\to\thisrepo\venv` to get it to work. 
3. Activate the virtual environment: `\. venv\bin\activate`
    + In Windows it will be in `.\venv\Scripts\activate`
4. Deactivate the virtual environment `deactivate` 
    + In Windows it will be in `.\venv\Scripts\deactivate.bat`
5. Install the requirements `pip install -r requirements.txt` with the virtual environment activated

## Setting up Alexa Skill in the Developer Console
1. Interaction Model:
    + current intent schema is in speechAssets\intent\_schema.txt
    + current sample utterances are in speechAssets\sample\_utterances.txt
2. Configuration
    + Service Endpoint Type: https
    + region: NA
    + service endpoint link: <https://b7f4tdxhtd.execute-api.us-east-1.amazonaws.com/dev>
3. SSL Certificate
    + "My development endpoint is a sub-domain of a domain that has a wildcard certificate from a certificate authority"

## Notes
I made the lambda using this [zappa tutorial.](https://developer.amazon.com/blogs/post/8e8ad73a-99e9-4c0f-a7b3-60f92287b0bf/new-alexa-tutorial-deploy-flask-ask-skills-to-aws-lambda-with-zappa "zappa tutorial")

If you don't feel like going through all that, feel free to use this endpoint I made as your service endpoint: <https://b7f4tdxhtd.execute-api.us-east-1.amazonaws.com/dev>.