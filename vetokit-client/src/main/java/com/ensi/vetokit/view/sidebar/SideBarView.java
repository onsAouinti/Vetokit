package com.ensi.vetokit.view.sidebar;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface SideBarView extends IsWidget {

    void setPresenter(Presenter listener);

    public interface Presenter {

        void goTo(Place place);

        void goToLaboratoirePlace();

        void goToClientPlace();
    }
}