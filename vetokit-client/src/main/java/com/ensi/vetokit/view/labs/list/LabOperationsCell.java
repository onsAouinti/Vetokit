package com.ensi.vetokit.view.labs.list;

import com.ensi.vetokit.resources.AppResources;
import com.ensi.vetokit.utils.VetokitConstants;
import com.ensi.vetokit.view.socle.CustomisedClickableCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safecss.shared.SafeStyles;
import com.google.gwt.safecss.shared.SafeStylesUtils;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.text.shared.SafeHtmlRenderer;
import com.google.gwt.text.shared.SimpleSafeHtmlRenderer;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

/**
 *
 * @author L.Pelov
 */
public class LabOperationsCell extends CustomisedClickableCell {
    /**
     * The HTML templates used to render the cell.
     */
    interface Templates extends SafeHtmlTemplates {

        @SafeHtmlTemplates.Template("<div name=\"{0}\" style=\"{4}\">{2}</div><div name=\"{1}\" style=\"{4}\">{3}</div>")
        SafeHtml cell(String nameDiv1, String nameDiv2, SafeHtml value1, SafeHtml value2, SafeStyles styles);
    }

    private static AppResources.AppImageResources imageResources = GWT.create(AppResources.AppImageResources.class);

    public LabOperationsCell() {
        this(SimpleSafeHtmlRenderer.getInstance());
    }

    public LabOperationsCell(SafeHtmlRenderer<String> renderer) {
        super(renderer);
    }

    /**
     * Create a singleton instance of the templates used to render the cell.
     */
    private static Templates templates = GWT.create(Templates.class);

    private static final SafeHtml EDIT_ICON = makeImage(imageResources.getEditIcon());
    private static final SafeHtml DELETE_ICON = makeImage(imageResources.getDeleteIcon());

    @Override
    protected void clickHandling(Context context, Element parent, String value,
                                 NativeEvent event, ValueUpdater<String> valueUpdater) {
        // Ignore clicks that occur outside of the outermost element.
        EventTarget eventTarget = event.getEventTarget();

        if (parent.isOrHasChild(Element.as(eventTarget))) {

            // use this to get the selected element!!
            Element el = Element.as(eventTarget);

            // check if we really click on the image
            if (el.getNodeName().equalsIgnoreCase(VetokitConstants.HTML_ELEMENT_IMG)) {
                doAction(el.getParentElement().getAttribute(VetokitConstants.HTML_ATTRIBUTE_NAME),
                        valueUpdater);
            }
        }
    }

    @Override
    protected SafeHtml getCustomisedCellSafeHtml() {
        return templates.cell(VetokitConstants.CSS_CLASS_EDIT_BUTTON,
                VetokitConstants.CSS_CLASS_DELETE_BUTTON, EDIT_ICON, DELETE_ICON,
                SafeStylesUtils.fromTrustedString("float:left;cursor:hand;cursor:pointer;"));
    }

    ;

    /**
     * onEnterKeyDown is called when the user presses the ENTER key will the
     * Cell is selected. You are not required to override this method, but its a
     * common convention that allows your cell to respond to key events.
     */
    @Override
    protected void onEnterKeyDown(Context context, Element parent,
                                  String value, NativeEvent event, ValueUpdater<String> valueUpdater) {
        doAction(value, valueUpdater);
    }

    /**
     * Intern action
     *
     * @param value
     *            selected value
     * @param valueUpdater
     *            value updater or the custom value update to be called
     */
    private void doAction(String value, ValueUpdater<String> valueUpdater) {
        // Trigger a value updater. In this case, the value doesn't actually
        // change, but we use a ValueUpdater to let the app know that a value
        // was clicked.
        if (valueUpdater != null)
            valueUpdater.update(value);
    }

    /**
     * Make icons available as SafeHtml
     * @param resource
     * @return
     */
    private static SafeHtml makeImage(ImageResource resource) {

        AbstractImagePrototype proto = AbstractImagePrototype.create(resource);
        return proto.getSafeHtml();
    }
}