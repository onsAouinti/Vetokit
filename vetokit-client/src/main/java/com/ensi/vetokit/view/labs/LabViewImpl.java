package com.ensi.vetokit.view.labs;

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
    CellTable laborList;

    private static final int LABS_PAGE_SIZE = 15;

    private TextColumn<Laboratory> nameColumn;
    private TextColumn<Laboratory> adresseColumn;

    /** * A simple data type that represents a Laboratory. */
    private static class Laboratory{
        private final String name;
        private final String address;
        public Laboratory(String name, String address)
        { this.name = name; this.address = address; }
    }

    private static final List<Laboratory> LABORS = Arrays.asList(
            new Laboratory("John", "123 Fourth Avenue"),
            new Laboratory("Joe", "22 Lance Ln"),
            new Laboratory("George", "1600 Pennsylvania Avenue"));

    /** * The list of data to display. */

    public LabViewImpl() {
        initlaborList();
        laborList.setRowCount(LABORS.size(), true);
        laborList.setRowData(0, LABORS);
        initWidget(uiBinder.createAndBindUi(this));

    }
    public void setPresenter(final Presenter listener) {
        presenter = listener;

    }

    private void initlaborList() {
        laborList = new CellTable<Laboratory>(LABS_PAGE_SIZE);
        laborList.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);
        nameColumn = new TextColumn<Laboratory>() {
            @Override
            public String getValue(Laboratory lab) {
                return lab.name;
            }
        };
        laborList.addColumn(nameColumn, "Name");

        adresseColumn = new TextColumn<Laboratory>() {
            @Override
            public String getValue(Laboratory lab) {
                return lab.address;
            }
        };
        laborList.addColumn(adresseColumn, "Address");
        laborList.setBordered(true);

        //Definition des largeurs de colonnes fixes
        laborList.setWidth("100%", true);
        laborList.setColumnWidth(nameColumn, 40.0, Style.Unit.PCT);
        laborList.setColumnWidth(adresseColumn, 17.0, Style.Unit.PCT);
    }


}