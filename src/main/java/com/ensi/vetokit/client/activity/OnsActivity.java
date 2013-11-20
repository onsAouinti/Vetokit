package com.ensi.vetokit.client.activity;

import com.ensi.vetokit.client.mvp.HasPlace;
import com.ensi.vetokit.client.place.ClientPlace;
import com.ensi.vetokit.client.place.OnsPlace;
import com.ensi.vetokit.client.view.client.ClientView;
import com.ensi.vetokit.client.view.ons.OnsView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: Ons
 * Date: 20/11/13
 * Time: 21:21
 * To change this template use File | Settings | File Templates.
 */
public class OnsActivity extends AbstractActivity implements HasPlace, OnsView.Presenter {

    @Inject
    private OnsView view;

    @Inject
    private PlaceController placeController;

    private OnsPlace place;


    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
        view.setPresenter(this);
        panel.setWidget(view.asWidget());

    }

    public void goTo(final Place place) {
        placeController.goTo(place);
    }

    public Activity setPlace(final Place place) {
        this.place = (OnsPlace) place;
        return this;
    }

}