package com.ensi.vetokit.client.mvp;


import com.ensi.vetokit.client.place.ClientPlace;
import com.ensi.vetokit.client.place.HomePlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ //
        HomePlace.Tokenizer.class, //
        ClientPlace.Tokenizer.class
})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}