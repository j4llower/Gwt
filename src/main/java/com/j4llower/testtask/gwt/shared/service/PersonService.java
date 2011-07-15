package com.j4llower.testtask.gwt.shared.service;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.j4llower.testtask.gwt.server.locator.DaoServiceLocator;
import com.j4llower.testtask.gwt.server.service.PersonDao;
import com.j4llower.testtask.gwt.shared.proxy.PersonProxy;

/**
 * Service stub for methods in personDao
 */
@Service(value = PersonDao.class, locator = DaoServiceLocator.class)
public interface PersonService extends RequestContext {

	Request<List<PersonProxy>> listAll();
	
}
