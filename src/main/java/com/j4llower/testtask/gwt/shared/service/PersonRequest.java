package com.j4llower.testtask.gwt.shared.service;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.j4llower.testtask.gwt.server.locator.PersonDaoLocator;
import com.j4llower.testtask.gwt.server.service.PersonDao;
import com.j4llower.testtask.gwt.shared.proxy.PersonProxy;

/**
 * Service stub for methods in PersonDao
 */
@Service(value = PersonDao.class, locator = PersonDaoLocator.class)
public interface PersonRequest extends RequestContext {

	Request<List<PersonProxy>> getAllPeople();
	
}