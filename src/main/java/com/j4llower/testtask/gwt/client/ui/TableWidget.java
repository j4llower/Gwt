package com.j4llower.testtask.gwt.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.SimplePager.Resources;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.j4llower.testtask.gwt.client.ClientFactory;
import com.j4llower.testtask.gwt.client.mvp.UserDataProvider;
import com.j4llower.testtask.gwt.shared.proxy.PersonProxy;

public class TableWidget extends Composite {

	private static TableWidgetUiBinder uiBinder = GWT
			.create(TableWidgetUiBinder.class);

	interface TableWidgetUiBinder extends UiBinder<Widget, TableWidget> {
	}

	private final ClientFactory clientFactory;
	private SimplePager pager;
	private UserDataProvider dataProvider;
	
	@UiField CellTable<PersonProxy> personList;
	
	public TableWidget(ClientFactory clientFactory) {
		initWidget(uiBinder.createAndBindUi(this));
		
		this.clientFactory = clientFactory;
		
		personList = new CellTable<PersonProxy>();
        personList.setPageSize(10);
        TextColumn<PersonProxy> firstNameCol = new TextColumn<PersonProxy>() {
            @Override
            public String getValue(PersonProxy object) {
                return object.getFirstName();
            }
        };
        personList.addColumn(firstNameCol, "First Name");
        TextColumn<PersonProxy> familyNameCol = new TextColumn<PersonProxy>() {
            @Override
            public String getValue(PersonProxy object) {
                return object.getFamilyName();
            }
        };
        personList.addColumn(familyNameCol, "Family Name");
        pager = new SimplePager(TextLocation.CENTER, (Resources) GWT.create(Resources.class), false, 1000, true);
        dataProvider = new UserDataProvider(clientFactory,pager);
        dataProvider.addDataDisplay(personList);
        pager.setDisplay(personList);
        VerticalPanel panel = new VerticalPanel();
        panel.add(personList);
        panel.add(pager);
	}

}
