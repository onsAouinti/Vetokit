package com.ensi.vetokit.view.labs;

import com.ensi.vetokit.dto.Laboratory;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface LabView extends IsWidget {

    void setPresenter(Presenter listener);

    void setLaboratoryOperationBtnsHandling(FieldUpdater<Laboratory, String> fieldUpdater);

    void deleteLaboratory(Laboratory laboratory);

    public interface Presenter {

        void goTo(Place place);
    }
}