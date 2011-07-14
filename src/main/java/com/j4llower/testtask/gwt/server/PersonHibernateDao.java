package com.j4llower.testtask.gwt.server;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.classic.Session;

import com.j4llower.testtask.gwt.client.Person;

public class PersonHibernateDao implements PersonDao {

    /**
     * Type of entity
     */
    private final Class<Person> type = getType();

    /**
     * Retrieves parametrized type of entity using reflection.
     *
     * @return type of entity
     */
    @SuppressWarnings("unchecked")
    private Class<Person> getType() {
        return (Class<Person>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * {@inheritDoc}
     */
    public void save(Person person) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(Long id) {
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        int result = session.createQuery("delete Person person where person.id= :id")
        		.setLong("id", id).executeUpdate();
        session.getTransaction().commit();
        return result != 0;
    }

    /**
     * {@inheritDoc}
     */
    public Person get(Long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Person person = (Person) session.get(type, id);
        session.getTransaction().commit();    	
        return person;
    }
    
    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
	public List<Person> getAll() {
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Person> persons = new ArrayList<Person>(session.createQuery("from Person")
        		.list());
        session.getTransaction().commit();    	
    	return persons;
    }    

    /**
     * {@inheritDoc}
     */
    public boolean isExist(Long id) {
        return get(id) != null;
    }
}
