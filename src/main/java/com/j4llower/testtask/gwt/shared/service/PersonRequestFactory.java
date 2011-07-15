package com.j4llower.testtask.gwt.shared.service;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface PersonRequestFactory extends RequestFactory {
	
	PersonService personRequest();
	
}
