package com.ensi.vetokit.view.labs.list;

import com.ensi.vetokit.dto.Laboratory;
import com.ensi.vetokit.view.socle.pager.Pager;
import com.ensi.vetokit.view.labs.popup.PopupLabView;
import com.ensi.vetokit.view.labs.popup.PopupLabViewImpl;
import com.ensi.vetokit.view.socle.OperationsColumn;
import com.github.gwtbootstrap.client.ui.*;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.RangeChangeEvent;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

public class LabViewImpl extends Composite implements LabView{

    private static ViewImplUiBinder uiBinder = GWT.create(ViewImplUiBinder.class);

    interface ViewImplUiBinder extends UiBinder<Widget, LabViewImpl> {
    }

    private Presenter presenter;

    @UiField(provided=true)
    CellTable labCellTable;
    @UiField
    TextBox searchTextBox;
    @UiField
    Button searchButtton;
    @UiField
    Button refreshButton;

    @Inject
    private PopupLabView popupView;

    private static final int LABS_PAGE_SIZE = 10;

    private TextColumn<Laboratory> raisonSocialeColumn;
    private TextColumn<Laboratory> emailColumn;
    private OperationsColumn<Laboratory> laboratoryOperationsColumn;

    private List<Laboratory> labList = new ArrayList<Laboratory>();
    ListDataProvider<Laboratory> dataProvider = new ListDataProvider<Laboratory>();

    @UiField
    Pager pager;

    @Inject
    public LabViewImpl() {
        popupView = new PopupLabViewImpl();
        pager= new Pager();
        loadLabs();
        initlaborList();
        initWidget(uiBinder.createAndBindUi(this));

  }

    public void setPresenter(final Presenter listener) {
        presenter = listener;

    }
    public void loadLabs(){

        Laboratory lab1 = new Laboratory();
        Laboratory lab2 = new Laboratory();
        Laboratory lab3 = new Laboratory();
        Laboratory lab4 = new Laboratory();
        Laboratory lab5 = new Laboratory();
        Laboratory lab6 = new Laboratory();
        Laboratory lab7 = new Laboratory();
        Laboratory lab8 = new Laboratory();
        Laboratory lab9 = new Laboratory();
        Laboratory lab10 = new Laboratory();
        Laboratory lab11 = new Laboratory();
        Laboratory lab12 = new Laboratory();
        Laboratory lab13 = new Laboratory();

        lab1.setRaisonSociale("Ons");
        lab1.setEmail("ons.aouinti@gmail.com");

        lab2.setRaisonSociale("Aymen");
        lab2.setEmail("aymen.kadri@gmail.com");

        lab3.setRaisonSociale("Ahmed");
        lab3.setEmail("ahmed.aouinti@gmail.com");

        lab4.setRaisonSociale("Ons");
        lab4.setEmail("ons.aouinti@gmail.com");

        lab5.setRaisonSociale("Aymen");
        lab5.setEmail("aymen.kadri@gmail.com");

        lab6.setRaisonSociale("Ahmed");
        lab6.setEmail("ahmed.aouinti@gmail.com");

        lab7.setRaisonSociale("Ons");
        lab7.setEmail("ons.aouinti@gmail.com");

        lab8.setRaisonSociale("Aymen");
        lab8.setEmail("aymen.kadri@gmail.com");

        lab9.setRaisonSociale("Ahmed");
        lab9.setEmail("ahmed.aouinti@gmail.com");

        lab10.setRaisonSociale("Salma");
        lab10.setEmail("salma.aouinti@gmail.com");

        lab11.setRaisonSociale("hihi");
        lab11.setEmail("hihi.kadri@gmail.com");

        lab12.setRaisonSociale("hahah");
        lab12.setEmail("hahah.aouinti@gmail.com");

        lab13.setRaisonSociale("hohoh");
        lab13.setEmail("hohoh.aouinti@gmail.com");

        labList.add(lab1);
        labList.add(lab2);
        labList.add(lab3);
        labList.add(lab4);
        labList.add(lab5);
        labList.add(lab6);
        labList.add(lab7);
        labList.add(lab8);
        labList.add(lab9);
        labList.add(lab10);
        labList.add(lab11);
        labList.add(lab12);
        labList.add(lab13);
        dataProvider.setList(labList);
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

        labCellTable.addRangeChangeHandler(new RangeChangeEvent.Handler() {

            public void onRangeChange(RangeChangeEvent event) {
                pager.rebuild();
            }
        });

        labCellTable.addColumn(laboratoryOperationsColumn, "Operations");
        pager.setDisplay(labCellTable);
        dataProvider.addDataDisplay(labCellTable);

        //Definition des largeurs de colonnes fixes
        labCellTable.setRowCount(labList.size(), true);
        labCellTable.setWidth("100%", true);
        labCellTable.setBordered(true);
        labCellTable.setColumnWidth(raisonSocialeColumn, 40.0, Style.Unit.PCT);
        labCellTable.setColumnWidth(emailColumn, 17.0, Style.Unit.PCT);
    }

    public void setLaboratoryOperationBtnsHandling(FieldUpdater<Laboratory, String> fieldUpdater) {
        laboratoryOperationsColumn.setFieldUpdater(fieldUpdater);

    }

    public void deleteLaboratory(Laboratory laboratory) {
        dataProvider.getList().remove(laboratory);
        dataProvider.flush();
        dataProvider.refresh();
        labCellTable.setRowCount(labList.size(), true);
        dataProvider.addDataDisplay(labCellTable);
        pager.rebuild();
    }

    public void editLaboratory(final Laboratory laboratory){
        Command command = new Command() {
            public void execute() {
                int i = labList.indexOf(laboratory);
               Laboratory lab =  popupView.getLaboratory();
               labList.set(i, lab);
               dataProvider.refresh();
               dataProvider.addDataDisplay(labCellTable);
              /* pager.rebuild();*/
            }
        };
        popupView.showPopup(laboratory, command);
    }

    @UiHandler("addButton")
    public void onAddClick(ClickEvent e) {
        Command command = new Command() {
            public void execute() {
                Laboratory lab =  popupView.getLaboratory();
                labList.add(lab);
                dataProvider.refresh();
                dataProvider.addDataDisplay(labCellTable);
                pager.rebuild();
            }
        };
        popupView.showPopup(new Laboratory(),command);
    }

    @UiHandler("searchButtton")
    public String onSearchClick(ClickEvent event) {
        String datakey =  this.searchTextBox.getText();
        for (Laboratory lab : labList)  {
            if (datakey.equals(lab.getRaisonSociale()))
            {
                labList.clear();
                labList.add(lab);
                dataProvider.setList(labList);
                dataProvider.refresh();
                dataProvider.addDataDisplay(labCellTable);
                pager.rebuild();
                return "";
            }
        }
        return "";
    }

    @UiHandler("refreshButton")
    public void onRefreshClick(ClickEvent event) {
        labList.clear();
        loadLabs();
        initlaborList();
    }
}
