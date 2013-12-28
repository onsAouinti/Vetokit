package com.ensi.vetokit.view.labs.popup;

import com.ensi.vetokit.dto.Laboratory;
import com.ensi.vetokit.view.socle.formitem.TextFormItem;
import com.github.gwtbootstrap.client.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;


public class PopupLabViewImpl extends Composite implements PopupLabView, Editor<Laboratory> {

    interface ViewImplUiBinder extends UiBinder<Widget, PopupLabViewImpl> {
    }
    interface Driver extends SimpleBeanEditorDriver<Laboratory, PopupLabViewImpl> {
    }

    Driver driver = GWT.create(Driver.class);

    private static ViewImplUiBinder uiBinder = GWT.create(ViewImplUiBinder.class);

    private Command command;

    @UiField
    Modal modal;

    @UiField
    TextFormItem raisonSociale;

    @UiField
    TextFormItem email;

    @UiField
    Button saveButton;

    public PopupLabViewImpl(){
        initWidget(uiBinder.createAndBindUi(this));
        driver.initialize(this);
        driver.edit(new Laboratory());
    }

    public void showPopup(Laboratory laboratory, Command command) {
        this.command = command;
        driver.edit(laboratory);
        modal.show();

     }

    @UiHandler("saveButton")
    public void onSaveClick(ClickEvent e) {
        modal.hide();
        command.execute();
    }

    public Laboratory getLaboratory() {
        return driver.flush();
    }
}