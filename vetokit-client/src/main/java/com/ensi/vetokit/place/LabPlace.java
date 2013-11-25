package com.ensi.vetokit.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class LabPlace extends Place {

    public static class Tokenizer implements PlaceTokenizer<LabPlace> {


        public String getToken(final LabPlace place) {
            return "";
        }


        public LabPlace getPlace(final String token) {
            return new LabPlace();
        }

    }
}
