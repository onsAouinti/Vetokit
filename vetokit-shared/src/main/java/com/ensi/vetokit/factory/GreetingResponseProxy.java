package com.ensi.vetokit.factory;

import com.google.web.bindery.requestfactory.shared.ProxyForName;
import com.google.web.bindery.requestfactory.shared.ValueProxy;

@ProxyForName("com.ensi.vetokit.GreetingResponse")
public interface GreetingResponseProxy extends ValueProxy {
	
	boolean isSuccessful();

	String getError();
	
	String getGreeting();

	String getServerInfo();

	String getUserAgent();
}