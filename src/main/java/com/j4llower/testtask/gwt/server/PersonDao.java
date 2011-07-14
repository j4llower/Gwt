package com.j4llower.testtask.gwt.server;

import java.util.List;

import com.j4llower.testtask.gwt.client.Person;

/**
 * Basic Data Access Object interface.
 * Provides CRUD operations with {@link Persistent} objects.
 */
public interface PersonDao {

    /**
     * Save the persistent object.
     *
     * @param person object to save
     */
    void save(Person person);

    /**
     * Delete the object by it's id.
     *
     * @param id the id
     * @return {@code true} if entity deleted successfully
     */
    boolean delete(Long id);

    /**
     * Get the object by id.
     *
     * @param id the id
     * @return loaded Person instance
     */
    Person get(Long id);
    
    /**
     * Get all object.
     *
     * @return loaded Person list
     */
    List<Person> getAll();

    /**
     * Check entity existance by id.
     *
     * @param id entity id
     * @return {@code true} if entity exist
     */
    boolean isExist(Long id);
}
