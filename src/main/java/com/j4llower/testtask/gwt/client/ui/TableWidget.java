package com.j4llower.testtask.gwt.client.ui;

import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.view.client.ListDataProvider;
import com.j4llower.testtask.gwt.client.service.ClientFactory;
import com.j4llower.testtask.gwt.shared.proxy.PersonProxy;
import com.j4llower.testtask.gwt.shared.service.PersonRequestFactory;

public class TableWidget extends CellTable<PersonProxy> {

	private Column<PersonProxy, String> itemColumn;
	private final ClientFactory clientFactory;
	
	TableWidget(ClientFactory clientFactory) {
		
		this.clientFactory = clientFactory;
		
		this.setPageSize(10);
		//this.addColumn(1, "Frist Name");
		//this.addColumn(1, "Family Name");
	}
		
	public void populate() {
		
		final PersonRequestFactory requestFactory = clientFactory.getRequestFactory();
		
		Request<List<PersonProxy>> findAllReq = requestFactory.personRequest().getAll();
		
		// Receiver specifies return type
		findAllReq.fire(new Receiver<List<PersonProxy>>()
		{
			@Override
			public void onSuccess(List<PersonProxy> response)
			{
				//updateRowCount(response.size(), true);
				//updateRowData(0, response);
			}
		});
		
	    // Create a CellList.
	    CellList<String> cellList = new CellList<String>(new TextCell());

	    // Create a list data provider.
	    final ListDataProvider<String> dataProvider = new ListDataProvider<String>();

	    // Add the cellList to the dataProvider.
	    dataProvider.addDataDisplay(cellList);
		
	    
        // Get the underlying list from data dataProvider.
        List<String> list = dataProvider.getList();

        // Add the value to the list. The dataProvider will update the cellList.
        list.add("");
		
		/*itemColumn = new Column<PersonProxy,String>(new TextCell())
		{
			@Override
			public String getValue(PersonProxy list)
			{
				return list.getName();
			}
		};*/
		
		/*final PersonRequestFactory factory = clientFactory.getRequestFactory();
		
		factory.personRequest().getAll().fire(new Receiver<List<PersonProxy>>() {
			  @Override
			  public void onSuccess(List<PersonProxy> persons) {
					
			  }
			});				
		 	*/

	}
}
