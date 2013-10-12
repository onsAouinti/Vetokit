package com.myApplication.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.TextBox;

public interface MyApplicationServiceAsync {
    void verifyEmail(String msg, AsyncCallback<String> async);
}
