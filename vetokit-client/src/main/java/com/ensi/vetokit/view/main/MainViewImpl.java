package com.ensi.vetokit.view.main;

import com.ensi.vetokit.activity.SideBarActivity;
import com.ensi.vetokit.view.sidebar.SideBarView;
import com.ensi.vetokit.view.sidebar.SideBarViewImpl;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.google.inject.Inject;

public class MainViewImpl extends Composite implements MainView {

    private static ViewImplUiBinder uiBinder = GWT.create(ViewImplUiBinder.class);

    interface ViewImplUiBinder extends UiBinder<Widget, MainViewImpl> {
    }

    private Presenter presenter;

    @UiField
    DisclosurePanel disclosurePanel;

    @UiField
    SideBarViewImpl sideBarViewImpl;

    @Inject
    private SideBarView view;
    SideBarActivity sideBarActivity;

    public MainViewImpl( ) {
        sideBarActivity = new SideBarActivity();
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setPresenter(Presenter listener) {
        sideBarViewImpl.setPresenter(sideBarActivity);
        presenter = listener;
    }

}