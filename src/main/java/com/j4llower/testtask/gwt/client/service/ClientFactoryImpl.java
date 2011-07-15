package com.j4llower.testtask.gwt.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.j4llower.testtask.gwt.client.GwtApp;
import com.j4llower.testtask.gwt.client.service.rpc.PersonStoreService;
import com.j4llower.testtask.gwt.client.service.rpc.PersonStoreServiceAsync;
import com.j4llower.testtask.gwt.client.ui.DesktopApp;
import com.j4llower.testtask.gwt.shared.service.PersonRequestFactory;

public class ClientFactoryImpl implements ClientFactory {
	
	private EventBus eventBus;
	private PersonRequestFactory personRequestFactory;	
	private PersonStoreServiceAsync personStoreService;
	private GwtApp app;	
		
	public PersonStoreServiceAsync getPersonStoreService() {
		if (personStoreService == null) {
			personStoreService = GWT.create(PersonStoreService.class);
		}
		return personStoreService;
	}

	public EventBus getEventBus() {
		if (eventBus == null) {
			eventBus = new SimpleEventBus();
		}
		return eventBus;
	}

	public PersonRequestFactory getRequestFactory() {
		if (personRequestFactory == null) {
			personRequestFactory = GWT.create(PersonRequestFactory.class);
			personRequestFactory.initialize(eventBus);
		}
		return personRequestFactory;
	}

	public GwtApp getApp() {
		if (app == null) {
			app = new DesktopApp(this);
		}
		return app;
	}
}
