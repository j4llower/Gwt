package com.j4llower.testtask.gwt.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.j4llower.testtask.gwt.client.ClientFactory;
import com.j4llower.testtask.gwt.shared.proxy.PersonProxy;

public class TableWidget extends Composite {

	private static TableWidgetUiBinder uiBinder = GWT
			.create(TableWidgetUiBinder.class);

	interface TableWidgetUiBinder extends UiBinder<Widget, TableWidget> {
	}

	private final ClientFactory clientFactory;
	
	@UiField CellTable<PersonProxy> table;
	
	public TableWidget(ClientFactory clientFactory) {
		initWidget(uiBinder.createAndBindUi(this));
		
		this.clientFactory = clientFactory;
	}

}
