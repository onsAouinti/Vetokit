package com.ensi.vetokit.view.client;

import com.github.gwtbootstrap.client.ui.CellTable;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ClientViewImpl extends Composite implements ClientView {

    private static ViewImplUiBinder uiBinder = GWT.create(ViewImplUiBinder.class);

    interface ViewImplUiBinder extends UiBinder<Widget, ClientViewImpl> {
    }

    private Presenter presenter;

    @UiField(provided = true)
    CellTable celltable ;


    public ClientViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setPresenter(final Presenter listener) {
        presenter = listener;
    }

}