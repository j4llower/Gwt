package com.j4llower.testtask.gwt.server.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.j4llower.testtask.gwt.domain.Person;
import com.j4llower.testtask.gwt.util.HibernateUtil;

public class PersonDao {

    @SuppressWarnings("unchecked")
    public List<Person> getAllPeople() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Person> people = new ArrayList<Person>(session.createQuery("from Person")
                .list());
        session.getTransaction().commit();    	
        return people;
    } 

}
