package com.j4llower.testtask.gwt.shared.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(com.j4llower.testtask.gwt.domain.Person.class)
public interface PersonProxy extends EntityProxy {

	String getFirstName();
	
	void setFirstName(String firstName);
	
	String getFamilyName();
	
	void setFamilyName(String familyName);
	
	public long getId();
}
