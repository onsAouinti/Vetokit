package com.ensi.vetokit.utils;

/**
 * Created with IntelliJ IDEA.
 * User: sfeir
 * Date: 20/12/12
 * Time: 16:39
 * To change this template use File | Settings | File Templates.
 */
public class VetokitConstants {

    /* Constantes URLs HTTP */
    public static final String HTTP_URL_PREFIX = "http://";

    /* Attributs generaux HTML */
    public static final String HTML_ATTRIBUTE_NAME = "name";
    public static final String HTML_ATTRIBUTE_VALUE = "value";
    public static final String HTML_ELEMENT_IMG = "IMG";

    /* HREF du front office */
    public static final String HREF_FRONT_OFFICE = "/vega/articles";

    /* Classes CSS boutons d'operations d'edition */
    public static final String CSS_CLASS_EDIT_BUTTON = "EDIT";
    public static final String CSS_CLASS_DELETE_BUTTON = "DELETE";

    /* DetailsArticle */

    //"Name" du "Hidden" contenant la value du format paragraphe selectionné
    public static final String NAME_HIDDEN_SELECTED_PARAGRAPH_FORMAT = "paraFormat";

    //"Values" possibles du "Hidden" dans DetailsArticleViewImpl.ui.xml
    public static final String FORM_VALUE_PARAGRAPH_FORMAT_1 = "1";
    public static final String FORM_VALUE_PARAGRAPH_FORMAT_2 = "2";
    public static final String FORM_VALUE_PARAGRAPH_FORMAT_3 = "3";

    //Names des TextArea des formats de paragraphe dans DetailsArticle
    public static final String NAME_TEXT_AREA_PARAGRAPH_FORMAT_1 = "format1Text";
    public static final String NAME_TEXT_AREA_PARAGRAPH_FORMAT_2 = "format2Text";
    public static final String NAME_TEXT_AREA_PARAGRAPH_FORMAT_3 = "format3Text";

    //"Names" des FileUpload pour la selection des images des paragraphe dans DetailsArticle
    public static final String NAME_FILE_UPLOAD_PARAGRAPH_FORMAT_2 = "filedUpload2";
    public static final String NAME_FILE_UPLOAD_PARAGRAPH_FORMAT_3 = "filedUpload3";

    //Constantes pour les messages d'alerte et d'information
    public static final String ALERT_MESSAGE_TITLE = "VeGA Information";
    public static final String CONFIRM_MESSAGE_TITLE = "VeGA Confirmation";
}