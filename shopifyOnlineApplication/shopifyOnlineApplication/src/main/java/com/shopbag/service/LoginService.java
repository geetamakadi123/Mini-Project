package com.shopbag.service;

import com.shopbag.exception.LoginException;
import com.shopbag.model.LoginData;

public interface LoginService {

	public String logInAccount(LoginData loginData) throws LoginException;
	public String logOutFromAccount(String key) throws LoginException;
	
}
