package com.monica.alexa.animename.handlers;

import com.monica.alexa.animename.utils.SkillUtils;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.impl.IntentRequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import java.util.Optional;

public class MyNameIsIntentHandler implements IntentRequestHandler {

    @Override
    public boolean canHandle(HandlerInput handlerInput, IntentRequest intentRequest) {
        return intentRequest.getIntent().getName().equals("MyNameIsIntent");
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput, IntentRequest intentRequest) {
    	
    	// This intent is called by AnimeNameStreamHandler when the Anime Fan states "my name is" followed by a name.
    	// The phrase "my name is" is defined as an Intent Utterance that will trigger this intent handler.

    	// (1) Retrieve and handle the name stored by Alexa in the wholenameSlot.  
    	// The Anime Fan stated this name to Alexa.
    	// Slot is combined with Intent Utterance in skill configuration:
    	// "my name is" {wholenameSlot}
        final Slot wholenameSlot = intentRequest.getIntent().getSlots().get("WholeName");
        String statedName = "";
        if (wholenameSlot != null) {
        	statedName = wholenameSlot.getValue().toLowerCase().trim();
       		}

        // (2) Generate and get the Anime Series Name, based on the name stated to Alexa.
        //
        //  The single slot "wholenameSlot" will populated with a string set to
        //  all the names stated by the Anime Fan. (eg: "James Tiberious Kirk").
        //  The method below will first parse these individual names.
        //  Next, it will pass them on as individual string arguments to the utility class PersonNames() for name-mapping.
        // 	
        final String animeName = SkillUtils.generateYourName(statedName);

        String speechOutput = "Otaku, I heard " + statedName + ".  ";
        speechOutput  = speechOutput  + "Okay, "  + statedName + " , Your anime series title is " + animeName;
        return handlerInput.getResponseBuilder()
                .withSpeech(speechOutput)
                .withSimpleCard("Anime Series Name Generator", speechOutput)
                .build();
    }
}
