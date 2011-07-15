package com.j4llower.testtask.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.j4llower.testtask.gwt.client.service.rpc.PersonStoreService;
import com.j4llower.testtask.gwt.client.service.rpc.PersonStoreServiceAsync;
import com.j4llower.testtask.gwt.shared.FieldVerifier;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Gwt implements EntryPoint {
	
	/**
	 * Create a remote service proxy to talk to the server-side PersonStore service.
	 */
	private final PersonStoreServiceAsync personStoreService = GWT
			.create(PersonStoreService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final TextBox firstNameField = new TextBox();
		final TextBox familyNameField = new TextBox();
		final Button addButton = new Button("Add");
		final Label errorLabel = new Label();
		
		firstNameField.setText("First Name");
		familyNameField.setText("Family Name");
		
		addButton.addStyleName("addButton");

		RootPanel.get("firstNameContainer").add(firstNameField);
		RootPanel.get("familyNameContainer").add(familyNameField);
		RootPanel.get("addButtonContainer").add(addButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);

		firstNameField.setFocus(true);
		firstNameField.selectAll();
		
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendInputToServer();
			}

			/**
			 * Fired when the user types in the familyNameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendInputToServer();
				}
			}

			/**
			 * Send the name from the firstNameField and familyNameField 
			 * to the server and wait for a response.
			 */
			private void sendInputToServer() {
				errorLabel.setText("");
				String firstNameToServer = firstNameField.getText();
				if (!FieldVerifier.isValidName(firstNameToServer)) {
					errorLabel.setText("First name should be at least two characters");
					return;
				}
				String familyNameToServer = firstNameField.getText();
				if (!FieldVerifier.isValidName(familyNameToServer)) {
					errorLabel.setText("Family name should be at least two characters");
					return;
				}
				
				String[] input = {firstNameToServer,familyNameToServer};

				addButton.setEnabled(false);
				personStoreService.storePerson(input,
						new AsyncCallback<String[]>() {
							public void onFailure(Throwable caught) {
								errorLabel.setText("Remote Procedure Call - Failure");
								errorLabel.addStyleName("serverResponseLabelError");
								addButton.setEnabled(true);
							}

							public void onSuccess(String[] arg0) {
								addButton.setEnabled(true);
							}
						});
			}
		}

		MyHandler handler = new MyHandler();
		addButton.addClickHandler(handler);
		familyNameField.addKeyUpHandler(handler);

	}

}
