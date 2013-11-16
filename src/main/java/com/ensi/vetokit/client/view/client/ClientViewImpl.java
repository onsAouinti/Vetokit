package com.ensi.vetokit.client.view.client;

import com.ensi.vetokit.shared.Person;
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

    private ListDataProvider<Person> dataProvider;

    @UiField(provided = true)
    CellTable celltable ;


    public ClientViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));

        Person person = new Person();
        dataProvider.getList().add(person);

        dataProvider = new ListDataProvider<Person>();
        dataProvider.addDataDisplay(celltable);
    }

    public void setPresenter(final Presenter listener) {
        presenter = listener;
    }

}