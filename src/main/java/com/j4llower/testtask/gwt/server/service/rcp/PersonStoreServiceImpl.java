package com.j4llower.testtask.gwt.server.service.rcp;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.j4llower.testtask.gwt.client.service.rpc.PersonStoreService;
import com.j4llower.testtask.gwt.domain.Person;
import com.j4llower.testtask.gwt.server.service.PersonDao;
import com.j4llower.testtask.gwt.server.service.hibernate.HibernateUtil;
import com.j4llower.testtask.gwt.server.service.hibernate.PersonHibernateDao;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonStoreServiceImpl extends RemoteServiceServlet implements PersonStoreService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
    /**
     * Dao object implementation.
     * @return 
     */
    /*private PersonDao dao;
    
    PersonStoreServiceImpl() {
    	dao = new PersonHibernateDao();
    }*/
    
	public String storePerson(String input) {
		logger.debug("Store person is {}", input);
		
		Person person = new Person(input,input);
		
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
		
	        /*Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	        List huhs = session.createQuery("from Huh").list();
	        session.getTransaction().commit();
	        return GWTUtil.clone(huhs);*/
		
		return "The person " + person.getFirstName() +  "has been saved";
		
		/*Person person = new Person(input,input);
		dao.save(person);*/
		
	}

}
