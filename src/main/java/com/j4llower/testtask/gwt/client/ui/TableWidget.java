package com.j4llower.testtask.gwt.client.ui;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Widget;
import com.j4llower.testtask.gwt.client.events.DataAvailableEvent;
import com.j4llower.testtask.gwt.client.mvp.UserDataProvider;
import com.j4llower.testtask.gwt.shared.proxy.PersonProxy;

public class TableWidget extends Composite {

	interface Binder extends UiBinder<Widget, TableWidget> {
	}

	@UiField
	Grid grid;
	
	private final UserDataProvider provider;

	private HandlerRegistration rowDataRegistration;	

	public TableWidget(UserDataProvider provider, int rowCount) {
		    this.provider = provider;
		    Binder binder = GWT.create(Binder.class);
		    initWidget(binder.createAndBindUi(this));
		    initTable(rowCount);
		  }
	
	/**
	  * Attach to the event bus only when the widget is attached to the DOM.
	  */
	@Override
	protected void onLoad() {
	    rowDataRegistration = provider.addRowDataHandler(
	    		new DataAvailableEvent.Handler() {
	    			public void onRowData(DataAvailableEvent event) {
	    				accept(event.getPeople());
	    			}
	    		});
	}

	@Override
	protected void onUnload() {
	    rowDataRegistration.removeHandler();
	}

	private void accept(List<PersonProxy> people) {

	    int destRowCount = getDataRowCount();
	    assert (people.size() <= destRowCount) : "Too many rows";

	    int srcRowIndex = 0;
	    int srcRowCount = people.size();
	    int destRowIndex = 1;
	    for (; srcRowIndex < srcRowCount; ++srcRowIndex, ++destRowIndex) {
	    	PersonProxy person = people.get(srcRowIndex);
	    	grid.setText(destRowIndex, 0, person.getFirstName());
	    	grid.setText(destRowIndex, 1, person.getFamilyName());
	    }
	}
	
	private int getDataRowCount() {
	    return grid.getRowCount();
	}
	
	private void initTable(int rowCount) {
	    grid.resizeRows(rowCount);
	}
}
