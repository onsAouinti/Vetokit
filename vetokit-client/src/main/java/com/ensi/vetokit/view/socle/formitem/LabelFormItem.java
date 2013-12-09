package com.ensi.vetokit.view.socle.formitem;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public abstract class LabelFormItem<T> extends FormItem<T> { // NOSONAR

    /**
     * Chaine de caractère à afficher dans un champ lorsqu'il n'y a pas de
     * valeur à affecter.
     */
    public static final String NOT_SPECIFIED_TEXT = "-";

    /**
     * Chaine de caractère à afficher dans un champ lorsque toutes les valeurs
     * sont à affecter.
     */
    protected static final String ALL = "Toutes";

    protected Label valueLabel;

    public LabelFormItem(Widget editableWidget) {
        super(editableWidget, new Label());
        valueLabel = (Label) readOnlyWidget;
    }

    @Override
    public void setValue(T value) {
        boolean valueIsNullOrEmpty = valueIsNullOrEmpty(value);

        if (!isEditing() && valueIsNullOrEmpty) {
            valueLabel.setText(NOT_SPECIFIED_TEXT);
        }

        doSetValue(value, valueIsNullOrEmpty);

        notifyUserFieldIsImportant(valueIsNullOrEmpty);
    }


    public void resetTwiceValue(T value) {
        boolean valueIsNullOrEmpty = valueIsNullOrEmpty(value);

        doSetValue(value, valueIsNullOrEmpty);
        valueLabel.setText(NOT_SPECIFIED_TEXT);
    }
}
