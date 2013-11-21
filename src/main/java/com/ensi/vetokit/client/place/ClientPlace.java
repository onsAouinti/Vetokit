package com.ensi.vetokit.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ClientPlace extends Place {

    public static class Tokenizer implements PlaceTokenizer<ClientPlace> {

        public String getToken(final ClientPlace place) {
            return "";
        }

        public ClientPlace getPlace(final String token) {
            return new ClientPlace();
        }

    }
}