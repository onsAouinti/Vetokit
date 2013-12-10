package com.ensi.vetokit.view.socle.formitem;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;

public interface FormItemResources extends GlobalResources {

    FormItemResources INSTANCE = GWT.create(FormItemResources.class);

    @ClientBundle.Source("images/yesPicto.png")
    @ImageOptions(repeatStyle = RepeatStyle.None)
    ImageResource yesPicto();

    @ClientBundle.Source("images/noPicto.png")
    @ImageOptions(repeatStyle = RepeatStyle.None)
    ImageResource noPicto();

    @ClientBundle.Source("images/picto-calendrier.png")
    @ImageOptions(repeatStyle = RepeatStyle.None)
    ImageResource pictoCalendrier();

    @ClientBundle.Source("formItem.css")
    Style style();

    interface Style extends CssResource {
        String formItem();

        String item();

        String label();

        String separator();

        String mandatory();

        String error();

        String input();

        String important();

        String importantReadOnly();

        String valueLabel();

        String smallWidget();

        String mediumWidget();

        String largeWidget();

        String xlargeWidget();

        String xxlargeWidget();

        String fieldDescription();

        String separatorContent();

        String hidden();

        String siretItem();

        String ibanItem();

        String checkBoxText();

        String inputContainer();
    }
}
