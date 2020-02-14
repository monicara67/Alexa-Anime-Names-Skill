/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package com.monica.alexa.animename.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.requestType;

public class LaunchRequestHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(requestType(LaunchRequest.class));
    }

    // Skill Invocation Name is "anime name".
    // This handler is called when the Anime Fan invokes the skill intent in his/her statement to Alexa.
    //  Example:  "launch anime name", "open anime name"
    
    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "Welcome, otaku!  This skill will generate an Anime Series Title for you based on your name.";
        String speechTextReprompt = "Please say, My Name Is, followed by your full name. "
        							+ "For example:  My Name Is James Tiberius Kirk.";
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Anime Series Name Generator", speechText)
                .withReprompt(speechTextReprompt)
                .build();
    }

}
