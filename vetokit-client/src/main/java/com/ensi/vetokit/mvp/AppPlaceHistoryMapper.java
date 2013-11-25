package com.ensi.vetokit.mvp;


import com.ensi.vetokit.place.ClientPlace;
import com.ensi.vetokit.place.HomePlace;
import com.ensi.vetokit.place.LabPlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ //
        HomePlace.Tokenizer.class, //
        ClientPlace.Tokenizer.class,
        LabPlace.Tokenizer.class
})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}