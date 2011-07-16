package com.j4llower.testtask.gwt.server.service.rcp;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.j4llower.testtask.gwt.client.service.rpc.PersonStoreService;
import com.j4llower.testtask.gwt.domain.Person;
import com.j4llower.testtask.gwt.server.service.PersonDao;
import com.j4llower.testtask.gwt.server.service.hibernate.PersonHibernateDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonStoreServiceImpl extends RemoteServiceServlet implements PersonStoreService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
    /**
     * Dao object implementation.
     */
    private PersonDao dao;
    
    PersonStoreServiceImpl() {
    	dao = new PersonHibernateDao();
    }
    
	public void storePerson(String input) {
		logger.debug("Store person is {}", input);
		Person person = new Person(input,input);
		dao.save(person);
		
	}

}
