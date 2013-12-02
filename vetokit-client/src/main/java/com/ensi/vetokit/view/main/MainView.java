package com.ensi.vetokit.view.main;

import com.ensi.vetokit.view.sidebar.SideBarView;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;

public interface MainView extends IsWidget {

    void setPresenter(Presenter listener);

    SideBarView getSideBarView();

    SimplePanel getCenterPanel();

    public interface Presenter {

        void goTo(Place place);
    }
}