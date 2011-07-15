package com.j4llower.testtask.gwt.client;

import com.google.gwt.event.shared.EventBus;
import com.j4llower.testtask.gwt.shared.service.PersonRequestFactory;

public interface ClientFactory {
	EventBus getEventBus();

	PersonRequestFactory getRequestFactory();

}
