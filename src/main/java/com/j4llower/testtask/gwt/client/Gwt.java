package com.j4llower.testtask.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.j4llower.testtask.gwt.client.service.ClientFactory;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Gwt implements EntryPoint {
	   
	private ClientFactory clientFactory;
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		clientFactory = GWT.create(ClientFactory.class);
		
		// Create ClientFactory using deferred binding so we can replace with
		// different
		// impls in gwt.xml
		 
        GwtApp app = clientFactory.getApp();
        Widget appWidget = app.getAppWidget();
        
		// Hide wait GIF
		DOM.removeChild(RootPanel.getBodyElement(), DOM.getElementById("loading"));
		
	}

}
