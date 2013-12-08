package com.ensi.vetokit.gin;


import com.ensi.vetokit.mvp.AppActivityMapper;
import com.ensi.vetokit.mvp.AppPlaceController;
import com.ensi.vetokit.mvp.AppPlaceHistoryMapper;
import com.ensi.vetokit.place.MainPlace;
import com.ensi.vetokit.requestfactory.AuthAwareRequestTransport;
import com.ensi.vetokit.view.client.ClientView;
import com.ensi.vetokit.view.client.ClientViewImpl;
import com.ensi.vetokit.view.home.HomeView;
import com.ensi.vetokit.view.home.HomeViewImpl;
import com.ensi.vetokit.view.labs.LabView;
import com.ensi.vetokit.view.labs.LabViewImpl;
import com.ensi.vetokit.view.labs.popup.PopupLabView;
import com.ensi.vetokit.view.labs.popup.PopupLabViewImpl;
import com.ensi.vetokit.view.main.MainView;
import com.ensi.vetokit.view.main.MainViewImpl;
import com.ensi.vetokit.view.menu.MenuView;
import com.ensi.vetokit.view.menu.MenuViewImpl;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.web.bindery.requestfactory.shared.RequestTransport;

public class VetokitModule extends AbstractGinModule {

    @Override
    protected void configure() {

        // MVP
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
        bind(ActivityMapper.class).to(AppActivityMapper.class).in(Singleton.class);
        bind(AppPlaceHistoryMapper.class).in(Singleton.class);

        bind(HomeView.class).to(HomeViewImpl.class).in(Singleton.class);
        bind(ClientView.class).to(ClientViewImpl.class).in(Singleton.class);
        bind(LabView.class).to(LabViewImpl.class).in(Singleton.class);
        bind(PopupLabView.class).to(PopupLabViewImpl.class).in(Singleton.class);
        bind(MenuView.class).to(MenuViewImpl.class).in(Singleton.class);
        bind(MainView.class).to(MainViewImpl.class).in(Singleton.class);

        bind(RequestTransport.class).to(AuthAwareRequestTransport.class);
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
        historyHandler.register(placeController, eventBus, new MainPlace());
        return historyHandler;
    }

}