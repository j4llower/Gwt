package com.j4llower.testtask.gwt.client.mvp;

import java.util.List;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.j4llower.testtask.gwt.client.events.DataAvailableEvent;
import com.j4llower.testtask.gwt.shared.proxy.PersonProxy;
import com.j4llower.testtask.gwt.shared.service.PersonRequestFactory;

public class UserDataProvider {
	private final HandlerManager handlerManager = new HandlerManager(this);
    
	private final PersonRequestFactory requests;
    
	public UserDataProvider(PersonRequestFactory requests) {
		    this.requests = requests;
		  }
	
	public HandlerRegistration addRowDataHandler(
	      DataAvailableEvent.Handler handler) {
	    return handlerManager.addHandler(DataAvailableEvent.TYPE, handler);
	}
	
	public void updateRowData() {

		requests.personRequest().getAllPeople().fire(
				new Receiver<List<PersonProxy>>() {
					@Override
		            public void onSuccess(List<PersonProxy> response) {
		                pushResults(response);
		              }
		        });
	} 
    
    private void pushResults(List<PersonProxy> people) {
        handlerManager.fireEvent(new DataAvailableEvent(people));
    }
}
