package com.monica.alexa.animename.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class CancelandStopIntentHandler implements RequestHandler {
	
   @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.StopIntent").or(intentName("AMAZON.CancelIntent")));
    }

  @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "See you later, otaku.";
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Anime Series Name Generator", speechText)
                .build();
    }
}