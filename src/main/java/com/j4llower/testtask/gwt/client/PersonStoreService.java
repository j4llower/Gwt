package com.j4llower.testtask.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("personStore")
public interface PersonStoreService extends RemoteService {
	
	void storePerson(String[] input) throws IllegalArgumentException;

}
