package com.ensi.vetokit.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface AppResources extends ClientBundle {

    @Source("VetokitStyle.css")
    VetokitStyle octopusStyle();

    public interface AppImageResources extends AppResources {

        @Source("images/logo_vega_65p.png")
        ImageResource logoOctopus();

    }



    public interface VetokitStyle extends CssResource {

    }
}