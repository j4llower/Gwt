package com.j4llower.testtask.gwt.server.service.rcp;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.j4llower.testtask.gwt.client.service.rpc.PersonStoreService;
import com.j4llower.testtask.gwt.domain.Person;
import com.j4llower.testtask.gwt.util.HibernateUtil;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class PersonStoreServiceImpl extends RemoteServiceServlet implements PersonStoreService {

private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Service object implementation.
     * @return 
     */
    public void savePerson(String input[]) {
        logger.debug("Store person is {}", input[0]);

        Person person = new Person(input[0],input[1]);

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();

        return;
}

}
