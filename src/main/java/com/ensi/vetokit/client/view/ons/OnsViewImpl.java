package com.ensi.vetokit.client.view.ons;

import com.ensi.vetokit.shared.Person;
import com.github.gwtbootstrap.client.ui.CellTable;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

public class OnsViewImpl extends Composite implements OnsView {

    private static ViewImplUiBinder uiBinder = GWT.create(ViewImplUiBinder.class);

    interface ViewImplUiBinder extends UiBinder<Widget, OnsViewImpl> {
    }

    private Presenter presenter;


    public OnsViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setPresenter(final Presenter listener) {
        presenter = listener;
    }

}