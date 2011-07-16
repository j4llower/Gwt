package com.j4llower.testtask.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.j4llower.testtask.gwt.client.service.rpc.PersonStoreService;
import com.j4llower.testtask.gwt.client.service.rpc.PersonStoreServiceAsync;
import com.j4llower.testtask.gwt.client.ui.DesktopApp;
import com.j4llower.testtask.gwt.shared.service.PersonRequestFactory;

public class ClientFactoryImpl implements ClientFactory {
	
	private final EventBus eventBus = new SimpleEventBus();
	private PersonStoreServiceAsync personStoreService = GWT.create(PersonStoreService.class);
	private PersonRequestFactory personRequestFactory = GWT.create(PersonRequestFactory.class);
	private GwtApp app = new DesktopApp(this);
	
	ClientFactoryImpl() {
		personRequestFactory.initialize(eventBus);
	}
		
	public PersonStoreServiceAsync getPersonStoreService() {
		return personStoreService;
	}

	public EventBus getEventBus() {
		return eventBus;
	}

	public PersonRequestFactory getRequestFactory() {
		return personRequestFactory;
	}

	public GwtApp getApp() {
		return app;
	}
}
