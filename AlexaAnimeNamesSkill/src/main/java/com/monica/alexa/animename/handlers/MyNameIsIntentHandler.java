/*
     Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

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
