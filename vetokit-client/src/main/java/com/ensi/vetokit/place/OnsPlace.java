package com.ensi.vetokit.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class OnsPlace extends Place {

    public static class Tokenizer implements PlaceTokenizer<OnsPlace> {


        public String getToken(final OnsPlace place) {
            return "";
        }


        public OnsPlace getPlace(final String token) {
            return new OnsPlace();
        }

    }
}
