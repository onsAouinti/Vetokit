package com.ensi.vetokit.factory;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

/**
 * The client side stub for the RequestFactory service.
 */
@ServiceName(value="com.ensi.vetokit.GreetingService", locator="com.ensi.vetokit.GuiceServiceLocator")
public interface GreetingContext extends RequestContext {
	Request<GreetingResponseProxy> greetServer(String name);
}
