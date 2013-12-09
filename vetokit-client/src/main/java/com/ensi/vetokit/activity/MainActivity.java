package com.ensi.vetokit.activity;


import com.ensi.vetokit.dto.Laboratory;
import com.ensi.vetokit.factory.AppFactory;
import com.ensi.vetokit.factory.GreetingResponseProxy;
import com.ensi.vetokit.mvp.HasPlace;
import com.ensi.vetokit.place.ClientPlace;
import com.ensi.vetokit.place.LabPlace;
import com.ensi.vetokit.place.MainPlace;
import com.ensi.vetokit.utils.VetokitConstants;
import com.ensi.vetokit.view.labs.list.LabViewImpl;
import com.ensi.vetokit.view.main.MainView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

public class MainActivity extends AbstractActivity implements HasPlace, MainView.Presenter  {

    @Inject
    private MainView view;

    @Inject
    private PlaceController placeController;

    private MainPlace place;

    @Inject
    private ClientPlace clientPlace;

    @Inject
    private LabPlace labPlace;

    @Inject
    private EventBus eventBus;

    private final AppFactory factory;

    @Inject
    private LabViewImpl labView;


    @Inject
    public MainActivity(AppFactory factory) {
        this.factory = factory;
    }

    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
        view.setPresenter(this);
        panel.setWidget(view.asWidget());

        labView.setLaboratoryOperationBtnsHandling(new FieldUpdater<Laboratory, String>() {

            public void update(int index, Laboratory laboratory, String value) {
                if (value.equals(VetokitConstants.CSS_CLASS_DELETE_BUTTON)) {
                    labView.deleteLaboratory(laboratory);
                } else if (value.equals(VetokitConstants.CSS_CLASS_EDIT_BUTTON)) {
                    labView.editLaboratory(laboratory);
                }
            }
        });

        //loadLaboratory();

    }

    public void loadLaboratory() {
        /*factory.greeting().greetServer("tess").fire(
                new Receiver<GreetingResponseProxy>() {
                    public void onFailure(ServerFailure failure) {

                    }

                    public void onSuccess(GreetingResponseProxy response) {

                    }
                });*/
    }

    public void goTo(final Place place) {
        placeController.goTo(place);
    }

    public Activity setPlace(final Place place) {
        this.place = (MainPlace) place;
        return this;
    }

}