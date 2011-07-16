package com.j4llower.testtask.gwt.client.mvp;

import java.util.List;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.web.bindery.requestfactory.shared.Receiver;
//import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.Range;
import com.j4llower.testtask.gwt.client.ClientFactory;
import com.j4llower.testtask.gwt.shared.proxy.PersonProxy;
import com.j4llower.testtask.gwt.shared.service.PersonRequestFactory;
import com.j4llower.testtask.gwt.shared.service.PersonService;

public class UserDataProvider extends AsyncDataProvider<PersonProxy> {
    
	private final ClientFactory clientFactory;
	private SimplePager pager;
    
    public UserDataProvider(ClientFactory clientFactory,SimplePager pager) {
        this.clientFactory = clientFactory;
    	this.pager = pager;
    }
    
    @Override
    protected void onRangeChanged(HasData<PersonProxy> display) {
        final CellTable<PersonProxy> table = (CellTable<PersonProxy>) display;
        final Range range = display.getVisibleRange();
  
        PersonRequestFactory requestFactory = clientFactory.getRequestFactory();
        PersonService personService = requestFactory.personRequest();
        personService.getAll().fire(new Receiver<List<PersonProxy>>() {
        	@Override
        	public void onSuccess(List<PersonProxy> response) {
                if (response.size() > 0) {
                	updateRowCount(response.size(), true);
    				updateRowData(0, response);
                    //updateRowData(range.getStart(), response);
                }
                
            }
            
        });
        
    }
}
