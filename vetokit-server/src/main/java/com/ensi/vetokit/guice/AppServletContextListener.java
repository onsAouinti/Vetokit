package com.ensi.vetokit.guice;

import com.google.common.base.Throwables;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.jndi.JndiIntegration;
import com.google.inject.name.Names;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.RequestScoped;
import com.google.inject.servlet.ServletModule;
import com.google.web.bindery.requestfactory.server.DefaultExceptionHandler;
import com.google.web.bindery.requestfactory.server.ExceptionHandler;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

public class AppServletContextListener extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		final Context ctx;
		try {
			InitialContext ic = new InitialContext();
			ctx = (Context) ic.lookup("java:comp/env");
		} catch (NamingException ne) {
			throw Throwables.propagate(ne);
		}

		return Guice.createInjector(new ServletModule() {
			@Override
			protected void configureServlets() {
				serve("/gwtRequest").with(GuiceRequestFactoryServlet.class);

				bind(ExceptionHandler.class).to(DefaultExceptionHandler.class);

				bind(Context.class).toInstance(ctx);
				bind(String.class).annotatedWith(Names.named("app/logoutUrl")).toProvider(
						JndiIntegration.fromJndi(String.class, "app/logoutUrl"));

				bind(User.class).annotatedWith(CurrentUser.class).to(ServerUser.class);
			}

			@Provides @CurrentUser @RequestScoped
            java.lang.String provideCurrentUser(HttpServletRequest request) {
				return request.getRemoteUser();
			}

			@Provides @IsAdmin @RequestScoped
			boolean provideIsAdmin(HttpServletRequest request) {
				return request.isUserInRole("admin");
			}
		});
	}
}

