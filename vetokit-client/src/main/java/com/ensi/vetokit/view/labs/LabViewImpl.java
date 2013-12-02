package com.ensi.vetokit.view.labs;

import com.ensi.vetokit.dto.Laboratory;
import com.ensi.vetokit.view.socle.OperationsColumn;
import com.github.gwtbootstrap.client.ui.*;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LabViewImpl extends Composite implements LabView, Editor<Laboratory> {

    private static ViewImplUiBinder uiBinder = GWT.create(ViewImplUiBinder.class);

    interface ViewImplUiBinder extends UiBinder<Widget, LabViewImpl> {
    }

    private Presenter presenter;

    @UiField(provided=true)
    CellTable labCellTable;

    private static final int LABS_PAGE_SIZE = 15;

    private TextColumn<Laboratory> raisonSocialeColumn;
    private TextColumn<Laboratory> emailColumn;
    private OperationsColumn<Laboratory> laboratoryOperationsColumn;

    private List<Laboratory> labList = new ArrayList<Laboratory>();

    Pagination pagination = new Pagination();
    SimplePager pager = new SimplePager();

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

        labList.add(lab1);
        labList.add(lab2);
        labList.add(lab3);
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

        laboratoryOperationsColumn = new OperationsColumn<Laboratory>(new LabOperationsCell()){
            @Override
            public String getValue(Laboratory laboratory) {
                return laboratory.getEmail();
            }
        };

        labCellTable.addColumn(laboratoryOperationsColumn, "Operations");

        pager.setDisplay(labCellTable);
        pagination.clear();

        //Definition des largeurs de colonnes fixes
        labCellTable.setWidth("100%", true);
        labCellTable.setBordered(true);
        labCellTable.setColumnWidth(raisonSocialeColumn, 40.0, Style.Unit.PCT);
        labCellTable.setColumnWidth(emailColumn, 17.0, Style.Unit.PCT);
    }

    public void setLaboratoryOperationBtnsHandling(FieldUpdater<Laboratory, String> fieldUpdater) {
        laboratoryOperationsColumn.setFieldUpdater(fieldUpdater);
    }

    public void deleteLaboratory(Laboratory laboratory) {
        labList.remove(laboratory);
        labCellTable.setRowCount(labList.size(), true);
        labCellTable.setRowData(0, labList);
    }

    private void rebuildPager(final Pagination pagination,final SimplePager pager) {
        pagination.clear();

        if (pager.getPageCount() == 0) {
            return;
        }

        NavLink prev = new NavLink("<");

        prev.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                GWT.log(String.valueOf("prev"));
                pager.previousPage();
            }
        });

        prev.setDisabled(!pager.hasPreviousPage());

        pagination.add(prev);

        int before = 2;
        int after = 2;

        while (!pager.hasPreviousPages(before) && before > 0) {
            before--;
            if(pager.hasNextPages(after + 1)) {
                after++;
            }
        }


        while (!pager.hasNextPages(after) && after > 0) {
            after--;
            if(pager.hasPreviousPages(before+1)) {
                before++;
            }
        }

        for (int i = pager.getPage() - before; i <= pager.getPage() + after; i++) {

            final int index = i + 1;

            NavLink page = new NavLink(String.valueOf(index));

            page.addClickHandler(new ClickHandler() {

                public void onClick(ClickEvent event) {
                    pager.setPage(index - 1);
                }
            });

            if (i == pager.getPage()) {
                page.setActive(true);
            }

            pagination.add(page);
        }

        NavLink next = new NavLink(">");

        next.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                GWT.log(String.valueOf("next"));
                pager.nextPage();
            }
        });

        next.setDisabled(!pager.hasNextPage());

        pagination.add(next);
    }



}