package com.ensi.vetokit.client.view.client;

import com.ensi.vetokit.shared.dto.Client;
import com.github.gwtbootstrap.client.ui.CellTable;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

public class ClientViewImpl extends Composite implements ClientView {

    private static ViewImplUiBinder uiBinder = GWT.create(ViewImplUiBinder.class);

    interface ViewImplUiBinder extends UiBinder<Widget, ClientViewImpl> {
    }

    private Presenter presenter;

    private ListDataProvider<Client> dataProvider;

    @UiField(provided = true)
    CellTable celltable ;


    public ClientViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));

        Client client = new Client();
        dataProvider.getList().add(client);

        dataProvider = new ListDataProvider<Client>();
        dataProvider.addDataDisplay(celltable);
    }

    public void setPresenter(final Presenter listener) {
        presenter = listener;
    }

}