package com.ensi.vetokit.mvp;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;

public class AppPlaceController extends PlaceController {

    @Inject
    public AppPlaceController(final EventBus eventBus) {
        super(eventBus);
    }

    private void goToNewPlace(final Place newPlace) {
        super.goTo(newPlace);
    }

    @Override
    public void goTo(final Place newPlace) {

        GWT.log("GoTo Place");
        goToNewPlace(newPlace);
    }

}