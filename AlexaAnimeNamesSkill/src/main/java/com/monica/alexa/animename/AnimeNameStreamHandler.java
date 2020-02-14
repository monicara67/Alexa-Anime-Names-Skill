package com.monica.alexa.animename;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

import com.monica.alexa.animename.handlers.LaunchRequestHandler;
import com.monica.alexa.animename.handlers.MyNameIsIntentHandler;
import com.monica.alexa.animename.handlers.CancelandStopIntentHandler;
import com.monica.alexa.animename.handlers.FallbackIntentHandler;
import com.monica.alexa.animename.handlers.HelpIntentHandler;
import com.monica.alexa.animename.handlers.SessionEndedRequestHandler;

public class AnimeNameStreamHandler extends SkillStreamHandler {
	
	// Note:  We need to do more work on Session-handling and name input validation.

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new LaunchRequestHandler(),
                        new MyNameIsIntentHandler(),
                        new CancelandStopIntentHandler(),
                        new HelpIntentHandler(),
                        new SessionEndedRequestHandler(),
                        new FallbackIntentHandler())
                // Add your skill id below.  
                // This is obtained in the Alexa Developer Console after you define your skill.
                .withSkillId("amzn1.ask.skill.b8c13442-74a4-446e-a5e0-7cafa7436a81")
                .build();
    }

    public AnimeNameStreamHandler() {
        super(getSkill());
    }

}
