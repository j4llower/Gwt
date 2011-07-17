package com.j4llower.testtask.gwt.server.locator;

import com.google.web.bindery.requestfactory.shared.Locator;
import com.j4llower.testtask.gwt.domain.Person;

public class PersonLocator extends Locator<Person, Long>{

	@Override
	public Person create(Class<? extends Person> clazz) {
		  try {
			  return clazz.newInstance();
		  } catch (InstantiationException e) {
			  throw new RuntimeException(e);
		  } catch (IllegalAccessException e) {
			  throw new RuntimeException(e);
		  }
	}

	@Override
	public Person find(Class<? extends Person> clazz, Long id) {
		// Never called
		return null;
	}

	@Override
	public Class<Person> getDomainType() {
		// Never called
		return null;
	}

	@Override
	public Long getId(Person person) {
		return person.getId();
	}

	@Override
	public Class<Long> getIdType() {
		return Long.class;
	}

	@Override
	public Object getVersion(Person person) {
		// Never called
		return null;
	}

}
