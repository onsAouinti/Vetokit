package com.ensi.vetokit.view.labs;

import com.ensi.vetokit.dto.Laboratory;
import com.github.gwtbootstrap.client.ui.CellTable;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import java.util.Arrays;
import java.util.List;

public class LabViewImpl extends Composite implements LabView {

    private static ViewImplUiBinder uiBinder = GWT.create(ViewImplUiBinder.class);

    interface ViewImplUiBinder extends UiBinder<Widget, LabViewImpl> {
    }

    private Presenter presenter;

    @UiField(provided=true)
    CellTable labCellTable;

    private static final int LABS_PAGE_SIZE = 15;

    private TextColumn<Laboratory> raisonSocialeColumn;
    private TextColumn<Laboratory> emailColumn;
    private List<Laboratory> labList;

    /** * The list of data to display. */

    public LabViewImpl() {
        initlaborList();
        loadLabs();
        labCellTable.setRowCount(labList.size(), true);
        labCellTable.setRowData(0, labList);
        initWidget(uiBinder.createAndBindUi(this));

    }

    public void setPresenter(final Presenter listener) {
        presenter = listener;

    }
    public void loadLabs(){
        Laboratory lab1 = new Laboratory();
        Laboratory lab2 = new Laboratory();
        Laboratory lab3 = new Laboratory();
        lab1.setRaisonSociale("Ons");
        lab1.setEmail("ons.aouinti@gmail.com");
        lab2.setRaisonSociale("Aymen");
        lab2.setEmail("aymen.kadri@gmail.com");
        lab3.setRaisonSociale("Ahmed");
        lab3.setEmail("ahmed.aouinti@gmail.com");
        labList = Arrays.asList(lab2, lab1,lab3);
    }
    

    private void initlaborList() {
        labCellTable = new CellTable<Laboratory>(LABS_PAGE_SIZE);
        labCellTable.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);
        raisonSocialeColumn = new TextColumn<Laboratory>() {
            @Override
            public String getValue(Laboratory lab) {
                return lab.getRaisonSociale();
            }
        };
        labCellTable.addColumn(raisonSocialeColumn, "Raison sociale");

        emailColumn = new TextColumn<Laboratory>() {
            @Override
            public String getValue(Laboratory lab) {
                return lab.getEmail();
            }
        };
        labCellTable.addColumn(emailColumn, "Email");
        labCellTable.setBordered(true);

        //Definition des largeurs de colonnes fixes
        labCellTable.setWidth("100%", true);
        labCellTable.setColumnWidth(raisonSocialeColumn, 40.0, Style.Unit.PCT);
        labCellTable.setColumnWidth(emailColumn, 17.0, Style.Unit.PCT);
    }


}