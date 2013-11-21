package com.ensi.vetokit.client.view.menu;

import com.github.gwtbootstrap.client.ui.NavLink;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MenuViewImpl extends Composite implements MenuView {

    private static ViewImplUiBinder uiBinder = GWT.create(ViewImplUiBinder.class);

    interface ViewImplUiBinder extends UiBinder<Widget, MenuViewImpl> {
    }

    @UiField
    NavLink disconnectionNav;
    @UiField
    NavLink clientNav;
    @UiField
    NavLink homeNav;

    private Presenter presenter;

    public MenuViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setPresenter(final Presenter listener) {
        presenter = listener;
    }

    @UiHandler("clientNav")
    public void clickOnClientNav(final ClickEvent event) {
        presenter.goToClientPlace();
    }

    @UiHandler("homeNav")
    public void clickOnHomeNav(final ClickEvent event) {
        presenter.goToHomePlace();
    }

    @UiHandler("disconnectionNav")
    public void clickOnDisconnectionNav(final ClickEvent event) {
        presenter.disconnect();
    }

}