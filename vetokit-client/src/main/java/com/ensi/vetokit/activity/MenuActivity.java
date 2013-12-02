package com.ensi.vetokit.activity;


import com.ensi.vetokit.place.ClientPlace;
import com.ensi.vetokit.place.HomePlace;
import com.ensi.vetokit.place.LabPlace;
import com.ensi.vetokit.view.menu.MenuView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class MenuActivity extends AbstractActivity implements MenuView.Presenter {



    @Inject
    private PlaceController placeController;

    @Inject
    private MenuView view;

    @Inject
    private HomePlace homePlace;
/*
    @Inject
    private ClientPlace clientPlace;

    @Inject
    private LabPlace labPlace;*/


    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
        view.setPresenter(this);
        panel.setWidget(view.asWidget());
    }

    public void goTo(final Place place) {
        placeController.goTo(place);
    }

    /*public void goToClientPlace() {
        goTo(clientPlace);
    }

    public void goToLaboratoirePlace() {
        goTo(labPlace);
    }*/

    public void goToHomePlace() {
        goTo(homePlace);
    }

    public void disconnect() {
        Window.alert("Disconnected");
    }

}