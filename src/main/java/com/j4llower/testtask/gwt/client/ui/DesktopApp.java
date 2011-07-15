package com.j4llower.testtask.gwt.client.ui;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.Widget;
import com.j4llower.testtask.gwt.client.GwtApp;
import com.j4llower.testtask.gwt.client.service.ClientFactory;

public class DesktopApp implements GwtApp{

	private final ClientFactory clientFactory;

	public DesktopApp(ClientFactory clientFactory)
	{
		this.clientFactory = clientFactory;
	}
	
	public Widget getAppWidget()
	{
		final FormWidget formWidget = new FormWidget(clientFactory);
	    final TableWidget tableWidget = new TableWidget(clientFactory);
		
		TabPanel tabPanel = new TabPanel();
	
		tabPanel.add(formWidget, " Add ");
	    tabPanel.add(tableWidget, " View ");
	    
	    tabPanel.selectTab(0);
	    
	    tabPanel.addSelectionHandler(new SelectionHandler<Integer>() {			
			public void onSelection(SelectionEvent<Integer> event) {
				if (event.getSelectedItem() == 1) {
					tableWidget.populate();
				}				
			}
		});
	    			
		return tabPanel;
	}
}
