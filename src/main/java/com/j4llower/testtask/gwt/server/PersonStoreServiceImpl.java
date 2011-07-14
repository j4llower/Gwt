package com.j4llower.testtask.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.j4llower.testtask.gwt.client.Person;
import com.j4llower.testtask.gwt.client.PersonStoreService;

public class PersonStoreServiceImpl extends RemoteServiceServlet implements PersonStoreService {
	
    /**
     * Dao object implementation.
     */
    protected PersonDao dao;
    
	public void storePerson(String[] input) {

		Person person = new Person(input[0],input[1]);
		dao.save(person);
		
	}

}
