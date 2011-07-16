package com.j4llower.testtask.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.j4llower.testtask.gwt.client.ui.FormWidget;
import com.j4llower.testtask.gwt.client.ui.TableWidget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Gwt implements EntryPoint {
	
	interface Binder extends UiBinder<Widget, Gwt> {
	}
	   
	private ClientFactory clientFactory = GWT.create(ClientFactory.class);
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
				
	    // Create a tab panel with three tabs, each of which displays a different
	    // piece of text.
	    TabPanel tabPanel = new TabPanel();
	    tabPanel.add(new FormWidget(clientFactory), "Add");
	    tabPanel.add(new TableWidget(clientFactory), "View");

	    tabPanel.selectTab(0);

	    RootPanel.get().add(tabPanel);
		
		//GwtApp app = clientFactory.getApp();
        //Widget appWidget = app.getAppWidget();
        
        //RootPanel.get("gwt").add(appWidget);
        
        //RootLayoutPanel.get().add(
        //        GWT.<Binder> create(Binder.class).createAndBindUi(this));
        
		// Hide wait GIF
		//DOM.removeChild(RootPanel.getBodyElement(), DOM.getElementById("loading"));
		
	}

}
