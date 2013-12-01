package com.ensi.vetokit.view.sidebar;

import com.github.gwtbootstrap.client.ui.NavLink;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class SideBarViewImpl extends Composite implements SideBarView {

    private static ViewImplUiBinder uiBinder = GWT.create(ViewImplUiBinder.class);

    interface ViewImplUiBinder extends UiBinder<Widget, SideBarViewImpl> {
    }

    @UiField
    NavLink laboratoryNav;
    @UiField
    NavLink clientNav;

    private Presenter presenter;

    public SideBarViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setPresenter(final Presenter listener) {
        presenter = listener;
    }


    @UiHandler("laboratoryNav")
    public void clickOnLaboratoireNav(final ClickEvent event) {
        //presenter.goToLaboratoirePlace();
    }

    @UiHandler("clientNav")
    public void clickOnClientNav(final ClickEvent event) {
        //presenter.goToClientPlace();
    }

}