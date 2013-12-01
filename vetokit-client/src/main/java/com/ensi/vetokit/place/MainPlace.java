package com.ensi.vetokit.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class MainPlace extends Place {

    public static class Tokenizer implements PlaceTokenizer<MainPlace> {

        public String getToken(final MainPlace place) {
            return "";
        }

        public MainPlace getPlace(final String token) {
            return new MainPlace();
        }

    }
}