package com.j4llower.testtask.gwt.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.j4llower.testtask.gwt.client.mvp.UserDataProvider;
import com.j4llower.testtask.gwt.client.service.rpc.PersonStoreService;
import com.j4llower.testtask.gwt.client.service.rpc.PersonStoreServiceAsync;

public class FormWidget extends Composite {

	interface Binder extends UiBinder<Widget, FormWidget> {
	}
	
	@UiField 
	Label errorLabel;
	@UiField 
	TextBox firstNameField;
	@UiField 
	TextBox familyNameField;
	@UiField 
	Button addButton; 
	
	private final UserDataProvider provider;
	
	public FormWidget(UserDataProvider provider) {
		this.provider = provider;
		Binder binder = GWT.create(Binder.class);
	    initWidget(binder.createAndBindUi(this));
	    initForm();
	}
	
	private void initForm() {
		final PersonStoreServiceAsync personStoreService = 
				GWT.create(PersonStoreService.class);
		
        addButton.addClickHandler(new ClickHandler() {
        	public void onClick(ClickEvent event) {

            	String firstNameToServer = firstNameField.getText();
 				String familyNameToServer = familyNameField.getText();
 				String input = firstNameToServer;

 				addButton.setEnabled(false);
 				personStoreService.storePerson(input,
 						new AsyncCallback<String>() {
 							public void onFailure(Throwable caught) {
 								errorLabel.setText("Remote Procedure Call - Failure: " +
 										caught.getMessage());
 								errorLabel.addStyleName("serverResponseLabelError");
 								addButton.setEnabled(true);
 							}

 							public void onSuccess(String result) {
 								errorLabel.setText("Remote Procedure Call - Success: " +
 										result);
 								//provider.updateRowData();
 								addButton.setEnabled(true);
 							}
 						});
 			}

        });
	}

}
