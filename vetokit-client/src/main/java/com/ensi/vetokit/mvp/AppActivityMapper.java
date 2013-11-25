package com.ensi.vetokit.mvp;


import com.ensi.vetokit.activity.ClientActivity;
import com.ensi.vetokit.activity.HomeActivity;
import com.ensi.vetokit.place.ClientPlace;
import com.ensi.vetokit.place.HomePlace;
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