package com.ensi.vetokit.activity;


import com.ensi.vetokit.mvp.HasPlace;
import com.ensi.vetokit.place.MainPlace;
import com.ensi.vetokit.view.main.MainView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class MainActivity extends AbstractActivity implements HasPlace, MainView.Presenter {

    @Inject
    private MainView view;

    @Inject
    private PlaceController placeController;

    private MainPlace place;

    @Inject
    private EventBus eventBus;

    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
        view.setPresenter(this);
        panel.setWidget(view.asWidget());

    }

    public void goTo(final Place place) {
        placeController.goTo(place);
    }

    public Activity setPlace(final Place place) {
        this.place = (MainPlace) place;
        return this;
    }

}