package com.ensi.vetokit.client.activity;


import com.ensi.vetokit.client.view.menu.MenuView;
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

    @Override
    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
        view.setPresenter(this);
        panel.setWidget(view.asWidget());
    }

    @Override
    public void goTo(final Place place) {
        placeController.goTo(place);
    }


    @Override
    public void disconnect() {
        Window.alert("Disconnected");
    }

}