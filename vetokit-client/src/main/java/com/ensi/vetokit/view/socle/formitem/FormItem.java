package com.ensi.vetokit.view.socle.formitem;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

/**
 * Le {@link FormItem} est l'élément à utiliser dans les formulaire, il est
 * constitué d'un {@link Label} et d'un {@link Widget}.<br>
 * Ces deux éléments sont séparés par ":".<br>
 * Il est possible de spécifier un mode d'édition, en mode éditable c'est le
 * {@link Widget} qui est affichée, si ce n'est pas le cas,<br>
 * elle est remplacée par un {@link Label} avec la même valeur.<br>
 * Il est également possible de rendre la saisie de ce champ obligatoire, auquel
 * cas, une "*" sera affichée à coté du {@link Label}.<br>
 * si la zone de saisie est vide, alors on remplace le text par la valeur de la
 * constante NOT_SPECIFIED_TEXT.<br>
 */
public abstract class FormItem<T> extends Composite { // NOSONAR

    public enum TextBoxSizeType {

        SMALL, MEDIUM, LARGE, XLARGE, XXLARGE

    }

    private static TextFormItemUiBinder uiBinder = GWT.create(TextFormItemUiBinder.class);

    interface TextFormItemUiBinder extends UiBinder<Widget, FormItem> {
    }

    /** Le Bundle contenant les Css associés au widget. */
    @UiField(provided = true)
    protected FormItemResources res = FormItemResources.INSTANCE;

    /** Le libellé du composant. */
    @UiField
    protected Label nameLabel;

    /**
     * Conteneur auquel ou dans lequel on peut ajouter le séparateur entre le
     * label et le champ de saisie.
     */
    @UiField
    protected Label separator;

    /** Le conteneur dans lequel est déposé le {@link Widget} d'édition. */
    @UiField
    protected FlowPanel inputContainer;

    /** Le conteneur dans lequel est déposé le {@link Widget} en lecture seule */
    @UiField
    protected SimplePanel readOnlyWidgetContainer;

    @UiField
    protected Label fieldDescriptionLabel;

    @UiField
    protected FlowPanel rootPanel;

    /** Indique si le champ est actuellement en mode édition. */
    private boolean editing;

    /** Indique si le champ doit obligatoirement être saisi. */
    private boolean mandatory;

    /** Indique s'il s'agit d'une saisie important ou pas */
    private boolean important;

    private boolean alwaysImportant;

    /** Indique si l'élément est visible ou pas */
    private boolean visible;

    /** Le champ de saisie */
    protected Widget editableWidget;

    /** Lewidget affiché lorsque l'élément n'est pas éditable. */
    protected Widget readOnlyWidget;

    public FormItem(Widget editableWidget, Widget readOnlyWidget) {
        initWidget(uiBinder.createAndBindUi(this));
        this.editableWidget = editableWidget;
        this.readOnlyWidget = readOnlyWidget;

        initInputwidget(editableWidget);
        initReadOnlyWidget(readOnlyWidget);

        setEditing(true);
        setMandatory(false);
        res.style().ensureInjected();

        inputContainer.addStyleName(res.style().inputContainer());

    }

    /**
     * Initilisation du champ de saisie.<br>
     * On l'ajoute dans le conteneur prévu à cet effet et on lui affecte un
     * certain nombre de styles.<br>
     *
     * @param widget : Le composant de saisie
     */
    protected final void initInputwidget(Widget widget) {
        inputContainer.add(widget);
        widget.addStyleName(res.style().item());
        widget.addStyleName(res.style().input());
    }

    /**
     * Initilisation du widget lecture seule
     *
     * @param widget : Le composant en lecture seule
     */
    protected final void initReadOnlyWidget(Widget widget) {
        readOnlyWidgetContainer.add(widget);
    }

    /**
     * Spécifie si le composant est en mode édition ou pas.<br>
     * Si c'est le cas, la {@link TextBox} est affichée, sinon, c'est le
     * {@link Label}.<br>
     *
     * @param editing
     */
    public void setEditing(boolean editing) {
        this.editing = editing;
        inputContainer.setVisible(editing);
        updateStyleFromMandatoryAndEditingStatus(mandatory, editing);
        readOnlyWidgetContainer.setVisible(!editing);
    }

    /**
     * Spécifie s'il s'agit d'un champ dont la saisie est obligatoire ou pas.<br>
     * En fonction de ça, on ajoute ou pas un style au {@link Label} du champ de
     * saisie.<br>
     *
     * @param mandatory
     */
    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
        updateStyleFromMandatoryAndEditingStatus(mandatory, editing);
    }

    /**
     * Adapte le style a assigné au label en fonction de si le champ est
     * obligatoire<br>
     * et de s'il est en mode édition.<br>
     *
     * @param mandatory
     * @param editing
     */
    protected void updateStyleFromMandatoryAndEditingStatus(boolean mandatory, boolean editing) {
        if (editing) {
            if (mandatory) {
                nameLabel.addStyleName(res.style().mandatory());
            }
            separator.removeStyleName(res.style().separatorContent());
        } else {
            nameLabel.removeStyleName(res.style().mandatory());
            separator.addStyleName(res.style().separatorContent());
        }
    }

    /**
     * Permet d'indiquer si un champ est important ou pas.<br>
     * Si c'est le cas, on le matérialsera avec un style particulier.<br>
     * Un champ important n'apparait comme tel dans l'IHM que si les données<br>
     * ne sont pas renseignés.<br>
     * La notion d'importance n'intervient pas dans le processus de validation<br>
     *
     * @param important
     */
    public void setImportant(boolean important) {
        this.important = important;
        if (!isDataFilled() && important) {
            notifyUserFieldIsImportant(true);
        } else {
            notifyUserFieldIsImportant(false);
        }
    }

    public void setAlwaysImportant(boolean important) {
        this.alwaysImportant = important;
        notifyUserFieldIsImportant(false);
    }

    /**
     * Il ne faut notifier l'utilisateur de manière graphique qu'un champ est
     * obligatoire<br>
     * que si aucune valeur n'est renseignée.<br>
     *
     * @param notify : indique s'il faut notifier l'utilisateur ou pas.
     */
    protected void notifyUserFieldIsImportant(boolean notify) {
        if ((notify && important) || alwaysImportant) {
            editableWidget.addStyleName(res.style().important());
            readOnlyWidget.addStyleName(res.style().importantReadOnly());
        } else {
            editableWidget.removeStyleName(res.style().important());
            readOnlyWidget.removeStyleName(res.style().importantReadOnly());
        }
    }

    /**
     * Handler permettant d'intercepter les changements de valeur.<br>
     */
    protected void onValueChanged() {
        boolean isValid = validate();
        setInError(!isValid);
    }

    /**
     * Handler permettant d'intercepter la sortie du champ.<br>
     */
    protected void onBlur() {
        boolean isValid = validate();
        setInError(!isValid);
    }

    /**
     * Méthode de validation vérifiant les critères d'obligation de saisie de
     * champ et d'importance.<br>
     */
    protected boolean validate() {
        boolean isValid;

        isValid = validateMandatoryCriteria();
        notifyUserFieldIsImportant(!isDataFilled());

        return isValid;
    }

    /**
     * Permet de savoir si l'éventuel caractère obligatoire de la saisie est
     * rempli ou pas.<br>
     */
    protected boolean validateMandatoryCriteria() {
        return (mandatory && isDataFilled()) || (!mandatory);
    }

    /**
     * Permet de savoir si le champ de saisie est vide ou pas en tenant<br>
     * compte du fait que le champ soit en édition ou non.<br>
     */
    protected abstract boolean isDataFilled();

    /**
     * Spécifie que la saisie n'est pas valide.
     */
    public void setInError(boolean isInError) {
        if (isInError) {
            this.addStyleName(res.style().error());
        } else {
            this.removeStyleName(res.style().error());
        }
    }

    /**
     * Le {@link FormItem} ayant un mode édition, lorsque l'on demande à
     * renseigner la valeur, des vérifications sont<br>
     * effectuées afin de voir quel champ remplir.<br>
     * Des vérifications sont également faites sur la valeur, dans le cas où
     * celle-ci est nulle ou vide, un affichage particulier est prévu.<br>
     * Le saisie dans à proprement parlé est déléguée à la méthode doSetValue.<br>
     * 
     * @param value
     */
    public void setValue(final T value) {
        boolean valueIsNullOrEmpty = valueIsNullOrEmpty(value);

        doSetValue(value, valueIsNullOrEmpty);

        notifyUserFieldIsImportant(valueIsNullOrEmpty);
    }

    /**
     * redimensionner la taille du widget
     * 
     * @param sizeType (SMALL, MEDIUM, LARGE, XLARGE, XXLARGE)
     */
    public void setSizeType(TextBoxSizeType sizeType) {
        switch (sizeType) {
            case SMALL:
                editableWidget.addStyleName(res.style().smallWidget());
                readOnlyWidgetContainer.addStyleName(res.style().smallWidget());
                break;
            case MEDIUM:
                editableWidget.addStyleName(res.style().mediumWidget());
                readOnlyWidgetContainer.addStyleName(res.style().mediumWidget());
                break;
            case LARGE:
                editableWidget.addStyleName(res.style().largeWidget());
                readOnlyWidgetContainer.addStyleName(res.style().largeWidget());
                break;
            case XLARGE:
                editableWidget.addStyleName(res.style().xlargeWidget());
                readOnlyWidgetContainer.addStyleName(res.style().xlargeWidget());
                break;
            case XXLARGE:
                editableWidget.addStyleName(res.style().xxlargeWidget());
                readOnlyWidgetContainer.addStyleName(res.style().xxlargeWidget());
                break;

            default:
                break;
        }
    }

    /**
     * ajouter une description en bas du widget
     */
    public void setFieldDescription(String fieldDescription) {
        fieldDescriptionLabel.setText(fieldDescription);
        fieldDescriptionLabel.setVisible(true);
    }

    /**
     * Méthode dans laquelle le remplissage effectif des champs doit être
     * effectué.<br>
     * 
     * @param value
     * @param valueIsNullOrEmpty
     */
    protected abstract void doSetValue(T value, boolean valueIsNullOrEmpty);

    /**
     * Méthode dans laquelle doit être implémentée la vérification que la valeur
     * est effectivement renseignée.<br>
     * 
     * @param value
     * @return
     */
    protected abstract boolean valueIsNullOrEmpty(T value);

    /**
     * Renseigne le libellé du champ de saisie.
     */
    public void setLabel(final String label) {
        nameLabel.setText(label);
    }

    @Override
    public void setVisible(boolean visible) {
        this.visible = visible;
        if (visible) {
            removeStyleName(res.style().hidden());
        } else {
            addStyleName(res.style().hidden());
        }
    }

    public boolean isEditing() {
        return editing;
    }

    public boolean isImportant() {
        return important;
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    public void setAsCell(boolean asCell) {
        if (asCell) {
            this.addStyleName(res.layout().cell());
        } else {
            this.removeStyleName(res.layout().cell());
        }
    }

    public void setLabelWidth(String labelWidth) {
        if ("0".equals(labelWidth)) {
            nameLabel.removeStyleName(res.layout().formLabelWidth());
        } else {
            nameLabel.removeStyleName(res.layout().formLabelWidth());
            nameLabel.setWidth(labelWidth);
        }
    }

    public void setLabel120px() {
        nameLabel.removeStyleName(res.layout().formLabelWidth());
        nameLabel.addStyleName(res.layout().formLabel120px());
    }

    public void setLabel80px() {
        nameLabel.removeStyleName(res.layout().formLabelWidth());
        nameLabel.addStyleName(res.layout().formLabel80px());
    }

    public void setLabel20px() {
        nameLabel.removeStyleName(res.layout().formLabelWidth());
        nameLabel.addStyleName(res.layout().formLabel20px());
    }

    public void setLabelWidth100px() {
        nameLabel.removeStyleName(res.layout().formLabelWidth());
        nameLabel.addStyleName(res.layout().formLabel100px());
    }

    public void setInputStyle(String style) {
        editableWidget.addStyleName(style);
    }

    public void setInputContainerStyle(String style) {
        inputContainer.addStyleName(style);
        readOnlyWidgetContainer.addStyleName(style);
    }

    public void reset() {
        setInError(false);
        notifyUserFieldIsImportant(false);
    }

    /*
     *permet de mettre le séparateyr ":" pour IE8
     */
    public void setSeparatorStyle() {
        separator.removeStyleName(res.style().separatorContent());
        separator.setText(" : ");
    }
}
