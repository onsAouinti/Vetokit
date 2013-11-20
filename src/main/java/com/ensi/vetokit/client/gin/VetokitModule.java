package com.ensi.vetokit.client.gin;


import com.ensi.vetokit.client.mvp.AppActivityMapper;
import com.ensi.vetokit.client.mvp.AppPlaceController;
import com.ensi.vetokit.client.mvp.AppPlaceHistoryMapper;
import com.ensi.vetokit.client.place.HomePlace;
import com.ensi.vetokit.client.view.client.ClientView;
import com.ensi.vetokit.client.view.client.ClientViewImpl;
import com.ensi.vetokit.client.view.home.HomeView;
import com.ensi.vetokit.client.view.home.HomeViewImpl;
import com.ensi.vetokit.client.view.menu.MenuView;
import com.ensi.vetokit.client.view.menu.MenuViewImpl;
import com.ensi.vetokit.client.view.ons.OnsView;
import com.ensi.vetokit.client.view.ons.OnsViewImpl;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class VetokitModule extends AbstractGinModule {

    @Override
    protected void configure() {

        // MVP
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
        bind(ActivityMapper.class).to(AppActivityMapper.class).in(Singleton.class);
        bind(AppPlaceHistoryMapper.class).in(Singleton.class);

        bind(HomeView.class).to(HomeViewImpl.class).in(Singleton.class);
        bind(ClientView.class).to(ClientViewImpl.class).in(Singleton.class);
        bind(OnsView.class).to(OnsViewImpl.class).in(Singleton.class);
        bind(MenuView.class).to(MenuViewImpl.class).in(Singleton.class);
    }

    @Singleton
    @Provides
    ActivityManager getActivityManager(final ActivityMapper activityMapper, final EventBus eventBus) {
        return new ActivityManager(activityMapper, eventBus);
    }

    @Singleton
    @Provides
    PlaceController getPlaceController(final EventBus eventBus) {
        return new AppPlaceController(eventBus);
    }

    @Singleton
    @Provides
    PlaceHistoryHandler getPlaceHistoryHandler(final AppPlaceHistoryMapper historyMapper, final EventBus eventBus, final PlaceController placeController) {
        final PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, new HomePlace());
        return historyHandler;
    }

}