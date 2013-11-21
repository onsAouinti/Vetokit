package com.ensi.vetokit.client.activity;


import com.ensi.vetokit.client.mvp.HasPlace;
import com.ensi.vetokit.client.place.ClientPlace;
import com.ensi.vetokit.client.place.HomePlace;
import com.ensi.vetokit.client.view.client.ClientView;
import com.ensi.vetokit.client.view.home.HomeView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class ClientActivity extends AbstractActivity implements HasPlace, ClientView.Presenter {

    @Inject
    private ClientView view;

    @Inject
    private PlaceController placeController;

    private ClientPlace place;

    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
        view.setPresenter(this);
        panel.setWidget(view.asWidget());

    }

    public void goTo(final Place place) {
        placeController.goTo(place);
    }

    public Activity setPlace(final Place place) {
        this.place = (ClientPlace) place;
        return this;
    }

}