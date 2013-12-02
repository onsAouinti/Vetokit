package com.ensi.vetokit.view.socle;

import com.google.gwt.user.cellview.client.Column;

public abstract class OperationsColumn<T> extends Column<T, String> {

    public OperationsColumn(CustomisedClickableCell cell) {
        super(cell);
    }
}