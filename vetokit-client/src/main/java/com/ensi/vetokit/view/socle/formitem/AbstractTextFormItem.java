package com.ensi.vetokit.view.socle.formitem;

import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;

/**
 * Champ de saisie de type {@link FormItem}, intégrant une {@link com.google.gwt.user.client.ui.TextBox}.
 */
public abstract class AbstractTextFormItem<T extends TextBox> extends LabelFormItem<String> implements
        ValidableComponent<String>, HasValue<String>, HasAllKeyHandlers {

    /** La {@link com.google.gwt.user.client.ui.TextBox} affichée lorsque l'élément est en mode édition. */
    protected T valueTextBox;

    @SuppressWarnings("unchecked")
    public AbstractTextFormItem(T textbox) {
        super(textbox);
        this.valueTextBox = (T ) editableWidget;
        initHandlers();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doSetValue(String value, boolean valueIsNullOrEmpty) {
        valueTextBox.setText(value);
        if (!valueIsNullOrEmpty) {
            valueLabel.setText(value);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean valueIsNullOrEmpty(String value) {
        boolean valueIsNullOrEmpty = value == null || value.isEmpty();
        return valueIsNullOrEmpty;
    }

    /**
     * Permet de savoir si le champ de saisie est vide ou pas en tenant<br>
     * compte du fait que le champ soit en édition ou non.<br>
     */
    @Override
    protected boolean isDataFilled() {
        String data = isEditing() ? valueTextBox.getText() : valueLabel.getText();
        return data != null && !data.isEmpty();
    }

    /**
     * Initialisation des handlers du champ de saisie.<br>
     * Permet d'activer les validations implémentées dans {@link FormItem}<br>
     */
    private void initHandlers() {
        this.valueTextBox.addValueChangeHandler(new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> event) {
                AbstractTextFormItem.this.onValueChanged();
            }
        });

        this.valueTextBox.addBlurHandler(new BlurHandler() {
            @Override
            public void onBlur(BlurEvent event) {
                AbstractTextFormItem.this.onBlur();
            }
        });

        this.valueTextBox.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                AbstractTextFormItem.this.onValueChanged();
            }
        });
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler) {
        return valueTextBox.addValueChangeHandler(handler);
    }

    @Override
    public String getValue() {
        String value = isEditing() ? valueTextBox.getText() : valueLabel.getText();
        return value;
    }

    @Override
    public void setValue(String value, boolean fireEvents) {
        valueTextBox.setValue(value, fireEvents);
    }

    public void setMaxLength(int maxLength) {
        valueTextBox.setMaxLength(maxLength);
    }

    public int getMaxLength() {
        return valueTextBox.getMaxLength();
    }

    public void setEnabled(boolean enabled) {
        valueTextBox.setEnabled(enabled);
    }

    @Override
    public HandlerRegistration addKeyDownHandler(KeyDownHandler handler) {
        return valueTextBox.addKeyDownHandler(handler);
    }

    @Override
    public HandlerRegistration addKeyPressHandler(KeyPressHandler handler) {
        return valueTextBox.addKeyPressHandler(handler);
    }

    @Override
    public HandlerRegistration addKeyUpHandler(KeyUpHandler handler) {
        return valueTextBox.addKeyUpHandler(handler);
    }
}
