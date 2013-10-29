package com.ensi.vetokit.client.mvp;


import com.ensi.vetokit.client.activity.ClientActivity;
import com.ensi.vetokit.client.activity.HomeActivity;
import com.ensi.vetokit.client.place.ClientPlace;
import com.ensi.vetokit.client.place.HomePlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class AppActivityMapper implements ActivityMapper {

    @Inject
    Provider<HomeActivity> homeActivityProvider;

    @Inject
    Provider<ClientActivity> clientActivityProvider;

    @Override
    public Activity getActivity(final Place place) {
        if (place instanceof HomePlace) {
            return homeActivityProvider.get().setPlace(place);
        }
        if (place instanceof ClientPlace) {
            return clientActivityProvider.get().setPlace(place);
        }
        return null;
    }

}