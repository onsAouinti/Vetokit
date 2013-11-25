package com.ensi.vetokit.view.menu;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface MenuView extends IsWidget {

    void setPresenter(Presenter listener);

    public interface Presenter {

        void goTo(Place place);
        void disconnect();
        void goToClientPlace();
        void goToHomePlace();
        void goToOnsPlace();
    }
}