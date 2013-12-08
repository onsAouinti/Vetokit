package com.ensi.vetokit.view.main;

import com.ensi.vetokit.view.client.ClientViewImpl;
import com.ensi.vetokit.view.labs.LabViewImpl;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class MainViewImpl extends Composite implements MainView {

    private static ViewImplUiBinder uiBinder = GWT.create(ViewImplUiBinder.class);
    interface ViewImplUiBinder extends UiBinder<Widget, MainViewImpl> {

    }

    @Inject
    private ClientViewImpl clientView;

    @Inject
    private LabViewImpl labView;

    private Presenter presenter;

    @Inject
    public MainViewImpl( ) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setPresenter(Presenter listener) {
        presenter = listener;
    }

}