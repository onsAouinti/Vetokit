package com.ensi.vetokit.view.ons;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

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