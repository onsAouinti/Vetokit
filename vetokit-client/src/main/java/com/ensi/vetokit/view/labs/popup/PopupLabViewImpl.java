package com.ensi.vetokit.view.labs.popup;

import com.ensi.vetokit.dto.Laboratory;
import com.ensi.vetokit.view.socle.formitem.TextFormItem;
import com.github.gwtbootstrap.client.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;


public class PopupLabViewImpl extends Composite implements PopupLabView {

    interface ViewImplUiBinder extends UiBinder<Widget, PopupLabViewImpl> {
    }
    private static ViewImplUiBinder uiBinder = GWT.create(ViewImplUiBinder.class);

    private Laboratory laboratory;

    private Command command;

    @UiField
    Modal modal;

    @UiField
    TextFormItem raisonSocialeField;

    @UiField
    TextFormItem emailField;

    @UiField
    Button saveButton;

    public PopupLabViewImpl(){

        initWidget(uiBinder.createAndBindUi(this));
    }

    public void showPopup(Laboratory laboratory, Command command) {
        this.command = command;
        this.laboratory= laboratory;
        raisonSocialeField.setValue(laboratory.getRaisonSociale());
        emailField.setValue(laboratory.getEmail());
        modal.show();

     }

    @UiHandler("saveButton")
    public void onSaveClick(ClickEvent e) {
        String newMail=emailField.getValue();
        String newRaisonSociale=raisonSocialeField.getValue();
        laboratory.setEmail(newMail);
        laboratory.setRaisonSociale(newRaisonSociale);
        modal.hide();
        command.execute();
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }
}