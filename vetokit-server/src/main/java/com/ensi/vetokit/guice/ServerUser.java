package com.ensi.vetokit.guice;

import com.google.inject.Inject;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.vm.AutoBeanFactorySource;

public class ServerUser implements User {

	private final String userName;
	private final boolean admin;

	@Inject
	ServerUser(@CurrentUser java.lang.String userName, @IsAdmin boolean admin) {
		this.userName = userName;
		this.admin = admin;
	}

	@Override
	public String getUserName() {
		return userName;
	}

	@Override
	public boolean isAdmin() {
		return admin;
	}

	public String toJson() {
		User.Factory factory = AutoBeanFactorySource.create(User.Factory.class);
		AutoBean<User> wrapper = factory.user(this);
		return AutoBeanCodex.encode(wrapper).getPayload();
	}
}

