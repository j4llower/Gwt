package com.j4llower.testtask.gwt.client.service.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
* The async counterpart of <code>PersonStoreServiceService</code>.
*/
public interface PersonStoreServiceAsync {
	
	void storePerson(String[] input, AsyncCallback<String[]> callback)
			throws IllegalArgumentException;
	
}
