package com.ensi.vetokit.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface AppResources extends ClientBundle {

    @Source("VetokitStyle.css")
    VetokitStyle octopusStyle();

    public interface AppImageResources extends AppResources {

        @Source("images/logo_vega_65p.png")
        ImageResource logoOctopus();

        @Source("images/edit_icon_grey.png")
        public ImageResource getEditIcon();

        @Source("images/delete_icon_black.png")
        public ImageResource getDeleteIcon();

    }



    public interface VetokitStyle extends CssResource {

    }
}