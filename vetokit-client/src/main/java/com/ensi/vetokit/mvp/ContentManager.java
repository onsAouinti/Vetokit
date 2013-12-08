package com.ensi.vetokit.mvp;


import com.ensi.vetokit.activity.HeaderActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class ContentManager implements PlaceChangeEvent.Handler {

    private AcceptsOneWidget display;

    @Inject
    private Provider<HeaderActivity> menuActivityProvider;

    @Inject
    private EventBus eventBus;

    public void onPlaceChange(final PlaceChangeEvent event) {

        final HeaderActivity menuActivity = menuActivityProvider.get();
        menuActivity.start(display, eventBus);

    }

    public void setDisplay(final AcceptsOneWidget simplePanel) {
        display = simplePanel;
        eventBus.addHandler(PlaceChangeEvent.TYPE, this);
    }

}