package com.ensi.vetokit.client.view.home;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface HomeView extends IsWidget {

    void setPresenter(Presenter listener);

    public interface Presenter {

        void goTo(Place place);
    }
}