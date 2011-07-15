package com.j4llower.testtask.gwt.client.service;

import com.google.gwt.event.shared.EventBus;
import com.j4llower.testtask.gwt.client.GwtApp;
import com.j4llower.testtask.gwt.client.service.rpc.PersonStoreServiceAsync;
import com.j4llower.testtask.gwt.shared.service.PersonRequestFactory;

public interface ClientFactory {

	//ListsView getListsView();

	//EditListView getEditListView();

	EventBus getEventBus();
	
	// RequestFactory
	PersonRequestFactory getRequestFactory();

	// RCP
	PersonStoreServiceAsync getPersonStoreService();

	GwtApp getApp();
	
}
