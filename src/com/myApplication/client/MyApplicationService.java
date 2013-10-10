package com.myApplication.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.client.ui.TextBox;

@RemoteServiceRelativePath("MyApplicationService")
public interface MyApplicationService extends RemoteService {
    // Sample interface method of remote interface
    String verifyEmail(String msg);

    /**
     * Utility/Convenience class.
     * Use MyApplicationService.App.getInstance() to access static instance of MyApplicationServiceAsync
     */
    public static class App {
        private static MyApplicationServiceAsync ourInstance = GWT.create(MyApplicationService.class);

        public static synchronized MyApplicationServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
