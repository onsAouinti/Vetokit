package com.ensi.vetokit.activity;


import com.ensi.vetokit.place.ClientPlace;
import com.ensi.vetokit.place.HomePlace;
import com.ensi.vetokit.place.LabPlace;
import com.ensi.vetokit.view.menu.MenuView;
import com.ensi.vetokit.view.sidebar.SideBarView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class SideBarActivity implements SideBarView.Presenter {



    @Inject
    private PlaceController placeController;

    @Inject
    private SideBarView view;

    @Inject
    private ClientPlace clientPlace;

    @Inject
    private LabPlace labPlace;


    public SideBarActivity() {
        view.setPresenter(this);
    }

    public void goTo(final Place place) {
        placeController.goTo(place);
    }

    public void goToClientPlace() {
        goTo(clientPlace);
    }

    public void goToLaboratoirePlace() {
        goTo(labPlace);
    }

}