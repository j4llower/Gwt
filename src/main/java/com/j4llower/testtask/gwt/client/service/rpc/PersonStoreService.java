package com.j4llower.testtask.gwt.client.service.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("rpc")
public interface PersonStoreService extends RemoteService {
	
	String storePerson(String input) throws IllegalArgumentException;

}
