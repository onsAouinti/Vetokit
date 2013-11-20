package com.ensi.vetokit.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: Ons
 * Date: 20/11/13
 * Time: 21:17
 * To change this template use File | Settings | File Templates.
 */
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
