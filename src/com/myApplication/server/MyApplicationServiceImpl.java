package com.myApplication.server;

import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.myApplication.client.MyApplicationService;
import java.util.regex.Matcher;

import java.util.regex.Pattern;

public class MyApplicationServiceImpl extends RemoteServiceServlet implements MyApplicationService {
    // Implementation of sample interface method
    public String verifyEmail(String msg) {

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[\\w]{2,4}$";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(msg);
        System.out.println(msg);
        return (matcher.matches()) ? "Valid email address" : "Malformed email address";
    }
}