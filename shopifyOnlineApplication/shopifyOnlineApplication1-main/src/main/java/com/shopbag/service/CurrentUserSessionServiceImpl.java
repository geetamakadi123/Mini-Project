package com.shopbag.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopbag.exception.LoginException;
import com.shopbag.model.CurrentUserSession;
import com.shopbag.model.Customer;
import com.shopbag.repository.CurrentUserSessionDao;
import com.shopbag.repository.CustomerDao;


@Service
public class CurrentUserSessionServiceImpl implements CurrentUserSessionService{
    
	@Autowired
	private CurrentUserSessionDao cusDao;
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public CurrentUserSession getCurrentUserSession(String key) throws LoginException {
          Optional<CurrentUserSession> currentUser = cusDao.findByUuid(key);
		
		if(currentUser.isPresent()) {
			return currentUser.get();
		}
		else {
			throw new LoginException("UnAuthorized");
		}
	}

	@Override
	public Integer getCurrentUserSessionId(String key) throws LoginException {
		 Optional<CurrentUserSession> currentUser = cusDao.findByUuid(key);
		 if(currentUser.isPresent()) {
				return currentUser.get().getId();
			}
			else {
				throw new LoginException("UnAuthorized");
			}
	}

	@Override
	public Customer getCustomerDetails(String key) {
		 Optional<CurrentUserSession> currentUser = cusDao.findByUuid(key);
		 if(currentUser.isPresent()) {
			Integer signUpUserId = 	currentUser.get().getUserId();
			 return (customerDao.findById(signUpUserId)).get();
			}
			else {
				return null;
			}
		 
		
	}
	
	
	



	
	
}
