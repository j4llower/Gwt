package com.j4llower.testtask.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.j4llower.testtask.gwt.client.mvp.UserDataProvider;
import com.j4llower.testtask.gwt.client.ui.FormWidget;
import com.j4llower.testtask.gwt.client.ui.TableWidget;
import com.j4llower.testtask.gwt.shared.service.PersonRequestFactory;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Gwt implements EntryPoint {
	
	interface Binder extends UiBinder<Widget, Gwt> {
	}

	@UiField(provided = true)
	FormWidget form;
	
	@UiField(provided = true)
	TableWidget table;

	@UiField
	TabLayoutPanel tabPanel;

	SimpleEventBus eventBus = new SimpleEventBus();
		
		/*public void fireEventFromSource(GwtEvent<?> event, Object source) {
		public void fireEvent(GwtEvent<?> event) {
		public <H extends EventHandler> HandlerRegistration addHandlerToSource(
		public <H extends EventHandler> HandlerRegistration addHandler( */

	//private ClientFactory clientFactory = GWT.create(ClientFactory.class);
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
				
	    PersonRequestFactory requests = GWT.create(PersonRequestFactory.class);
	    requests.initialize(eventBus);
	    final UserDataProvider provider = new UserDataProvider(requests);

	    form = new FormWidget(provider);
	    table = new TableWidget(provider, 10);

	    tabPanel = new TabLayoutPanel(60, Unit.PCT);

	    tabPanel.add(form, "Add");
	    tabPanel.add(table, "View");
	    tabPanel.add(new HTML("TEST"), "Test2");
	    
	    tabPanel.addSelectionHandler(new SelectionHandler<Integer>() {
			public void onSelection(SelectionEvent<Integer> event) {
				if (event.getSelectedItem() == 2) {
					provider.updateRowData();
					tabPanel.add(new HTML("TEST"), "Test3");
				}
			}
		});
	    
	    RootLayoutPanel.get().add(tabPanel);
	    
	    /*RootLayoutPanel.get().add(
		        GWT.<Binder> create(Binder.class).createAndBindUi(this)); */

	    /*TabPanel tabPanel = new TabPanel();
	    tabPanel.add(form, "Add");
	    tabPanel.add(table, "View");
	    tabPanel.add(new HTML("TEST"), "Test");

	    tabPanel.selectTab(0);
	    
	    tabPanel.addSelectionHandler(new SelectionHandler<Integer>() {
			public void onSelection(SelectionEvent<Integer> event) {
				if (event.getSelectedItem() == 2) {
					provider.updateRowData();
				}
			}
		});*/

	    //RootPanel.get().add(tabPanel);
	    
	    /* RootLayoutPanel.get().add(
	        GWT.<Binder> create(Binder.class).createAndBindUi(this)); */
		
	    // Create a tab panel with three tabs, each of which displays a different
	    // piece of text.
	    /*TabPanel tabPanel = new TabPanel();
	    tabPanel.add(new FormWidget(), "Add");
	    tabPanel.add(new TableWidget(), "View");

	    tabPanel.selectTab(0);

	    RootPanel.get().add(tabPanel); */
		
		//GwtApp app = clientFactory.getApp();
        //Widget appWidget = app.getAppWidget();
        
        //RootPanel.get("gwt").add(appWidget);
        
        //RootLayoutPanel.get().add(
        //        GWT.<Binder> create(Binder.class).createAndBindUi(this));
        
		// Hide wait GIF
		//DOM.removeChild(RootPanel.getBodyElement(), DOM.getElementById("loading"));
		
	}

}