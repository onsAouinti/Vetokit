package com.ensi.vetokit.view.main;

import com.ensi.vetokit.view.home.HomeViewImpl;
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

    @UiField
    SimplePanel centerPanel;

    /*@UiField
    TabPanel tabPanel;*/

    @Inject
    SideBarView view;

    @Inject
    public MainViewImpl( ) {
        initWidget(uiBinder.createAndBindUi(this));
        /*HomeViewImpl homeViewImpl = new HomeViewImpl();
        tabPanel.add(homeViewImpl, "");*/
    }

    public void setPresenter(Presenter listener) {
        presenter = listener;
    }

    public SideBarView getSideBarView() {
        return sideBarViewImpl;
    }

    public SimplePanel getCenterPanel() {
        return centerPanel;
    }

}