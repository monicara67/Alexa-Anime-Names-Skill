# AlexaAnimeNamesSkill
#### Custom Alexa Skill for generating anime names based on a person's name ####

Hello!  This is my first custom Amazon Alexa Skill.  

When you invoke the skill by saying "*Alexa, open anime name*," it will prompt you for your first, middle and last name. 
Alexa will then generate your custom anime series name based on your initials.

This project was my introduction to AWS Toolkit features along with Amazaon Alexa custom skill development.  
The Amazon development web sites were of great help, providing tutorials and sample code.

All of the handler classes were based on sample code that was provided by Amazon. 
However, the following classes were written by me to provide the core skill logic of processing the person's name and generating the anime name.

  -  [com.monica.alexa.animename.handlers.MyNameIsIntentHandler](https://github.com/monicara67/AlexaAnimeNamesSkill/blob/master/AlexaAnimeNamesSkill/src/main/java/com/monica/alexa/animename/handlers/MyNameIsIntentHandler.java)

  -  all classes in [package com.monica.alexa.animename.utils](https://github.com/monicara67/AlexaAnimeNamesSkill/tree/master/AlexaAnimeNamesSkill/src/main/java/com/monica/alexa/animename/utils)

This skill requires further development work for session handling, a more sophisticated interaction model and improved error handling.  But it's a nice start and has been great fun to share with friends, especially anime fans!

