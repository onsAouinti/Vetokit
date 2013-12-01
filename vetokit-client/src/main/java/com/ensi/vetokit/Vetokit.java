package com.ensi.vetokit;

import com.ensi.vetokit.gin.VetokitInjector;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Vetokit implements EntryPoint {
  public void onModuleLoad() {
      final VetokitInjector ginjector = GWT.create(VetokitInjector.class);

      final SimplePanel menuDisplay = ginjector.getWidget();
      ginjector.getContentManager().setDisplay(menuDisplay);

      /*final SimplePanel sideBar = ginjector.getWidget();
      ginjector.getContentManager().setDisplay(sideBar);*/

      final SimplePanel activityDisplay = ginjector.getWidget();
      ginjector.getActivityManager().setDisplay(activityDisplay);

      RootPanel.get("menu").add(menuDisplay);
      //RootPanel.get("side-bar").add(sideBar);
      RootPanel.get("body").add(activityDisplay);

      ginjector.getPlaceHistoryHandler().handleCurrentHistory();
  }

}
