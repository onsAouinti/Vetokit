package com.ensi.vetokit.view.socle;

import com.google.gwt.cell.client.AbstractSafeHtmlCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.text.shared.SafeHtmlRenderer;
import com.google.gwt.text.shared.SimpleSafeHtmlRenderer;

/**
 * Using the new GWT 2.2 way to implement cell.
 *
 * @author L.Pelov
 */
public abstract class CustomisedClickableCell extends AbstractSafeHtmlCell<String> {


    public CustomisedClickableCell() {
        this(SimpleSafeHtmlRenderer.getInstance());
    }

    public CustomisedClickableCell(SafeHtmlRenderer<String> renderer) {
        super(renderer, ClickEvent.getType().getName(), KeyDownEvent.getType().getName());
    }

    /**
     * Called when an event occurs in a rendered instance of this Cell. The
     * parent element refers to the element that contains the rendered cell, NOT
     * to the outermost element that the Cell rendered.
     */
    @Override
    public void onBrowserEvent(com.google.gwt.cell.client.Cell.Context context,
                               Element parent, String value, NativeEvent event,
                               com.google.gwt.cell.client.ValueUpdater<String> valueUpdater) {

        // Let AbstractCell handle the keydown event.
        super.onBrowserEvent(context, parent, value, event, valueUpdater);

        // Handle the click event.
        if ("click".equals(event.getType())) {

            clickHandling(context, parent, value, event, valueUpdater);
        }

    }

    protected abstract void clickHandling(Context context, Element parent, String value, NativeEvent event, ValueUpdater<String> valueUpdater);

    @Override
    protected void render(com.google.gwt.cell.client.Cell.Context context,
                          SafeHtml data, SafeHtmlBuilder sb) {
        /*
         * Always do a null check on the value. Cell widgets can pass null to
         * cells if the underlying data contains a null, or if the data arrives
         * out of order.
         */
        if (data == null) {
            return;
        }

        SafeHtml safeHtml = getCustomisedCellSafeHtml();

        sb.append(safeHtml);
    }

    protected abstract SafeHtml getCustomisedCellSafeHtml();
}