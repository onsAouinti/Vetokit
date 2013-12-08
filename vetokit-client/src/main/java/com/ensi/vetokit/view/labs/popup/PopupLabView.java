package com.ensi.vetokit.view.labs.popup;

import com.ensi.vetokit.dto.Laboratory;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.IsWidget;


public interface PopupLabView extends IsWidget {

    void setPresenter(Presenter listener);
    void showPopup(Laboratory laboratory, Command command);
    Laboratory getLaboratory();
    public interface Presenter {

        void goTo(Place place);
    }
}