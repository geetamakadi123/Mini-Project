package com.shopbag.service;

import com.shopbag.exception.LoginException;
import com.shopbag.model.CurrentUserSession;
import com.shopbag.model.Customer;

public interface CurrentUserSessionService {

	public CurrentUserSession getCurrentUserSession(String key) throws LoginException;
	public Integer getCurrentUserSessionId(String key) throws LoginException;
	
	public Customer getCustomerDetails(String key);
	
}
