package com.ensi.vetokit.mvp;


import com.ensi.vetokit.place.ClientPlace;
import com.ensi.vetokit.place.HomePlace;
import com.ensi.vetokit.place.OnsPlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ //
        HomePlace.Tokenizer.class, //
        ClientPlace.Tokenizer.class,
        OnsPlace.Tokenizer.class
})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}