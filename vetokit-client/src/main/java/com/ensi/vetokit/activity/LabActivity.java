package com.ensi.vetokit.activity;

import com.ensi.vetokit.dto.Laboratory;
import com.ensi.vetokit.mvp.HasPlace;
import com.ensi.vetokit.place.LabPlace;
import com.ensi.vetokit.utils.VetokitConstants;
import com.ensi.vetokit.view.labs.LabView;
import com.ensi.vetokit.view.main.MainView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class LabActivity extends AbstractActivity implements HasPlace, LabView.Presenter {

    @Inject
    private LabView view;

    @Inject
    private MainView mainView;

    @Inject
    private PlaceController placeController;

    private LabPlace place;

    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
        view.setPresenter(this);
        panel.setWidget(view.asWidget());

        view.setLaboratoryOperationBtnsHandling(new FieldUpdater<Laboratory, String>() {

            public void update(int index, Laboratory laboratory, String value) {
                if (value.equals(VetokitConstants.CSS_CLASS_DELETE_BUTTON)) {
                    view.deleteLaboratory(laboratory);
                }

            }
        });

    }

    public void goTo(final Place place) {
        placeController.goTo(place);
    }

    public Activity setPlace(final Place place) {
        this.place = (LabPlace) place;
        return this;
    }

}