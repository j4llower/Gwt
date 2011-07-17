package com.j4llower.testtask.gwt.server.locator;

import com.google.web.bindery.requestfactory.shared.ServiceLocator;

public class PersonDaoLocator implements ServiceLocator {

    public Object getInstance(Class<?> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
