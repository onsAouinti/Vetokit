package com.ensi.vetokit.view.socle.formitem;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;

public interface GlobalResources extends ClientBundle {

    GlobalResources INSTANCE = GWT.create(GlobalResources.class);

    @Source("images/externalLink.png")
    @ImageOptions(repeatStyle = RepeatStyle.None)
    ImageResource externalLink();

    @Source("images/redArrow.png")
    @ImageOptions(repeatStyle = RepeatStyle.None)
    ImageResource redArrow();

    @Source("layout.css")
    Layout layout();

    interface Layout extends CssResource {
        String marginItem();

        String alignRight();

        String cell();

        String formLabel();

        String formLabelWidth();

        String externalLink();

        String containExternalLink();

        String containInternalLink();

        String disabled();

        String formLabel120px();

        String formLabel20px();

        String formLabel100px();

        String formLabel80px();

        String menuLink();

        String anchorLink();

        String tabPanel();

        String scrollableContainer();
    }
}
