package com.ensi.vetokit.view.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface ClientView extends IsWidget {

    void setPresenter(Presenter listener);

    public interface Presenter {

        void goTo(Place place);
    }
}