package com.shopbag.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopbag.exception.LoginException;
import com.shopbag.model.CurrentUserSession;
import com.shopbag.model.Customer;
import com.shopbag.model.LoginData;
import com.shopbag.repository.CurrentUserSessionDao;
import com.shopbag.repository.CustomerDao;
import com.shopbag.repository.LoginDataDao;



@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private CurrentUserSessionDao cusDao;
	
	@Autowired
	private CurrentUserSessionService cusService;
	
	@Autowired
	private LoginDataDao loginDao;
	
	
	@Override
	public String logInAccount(LoginData loginData) throws LoginException {
		
		Optional<Customer> opt = customerDao.findByEmail(loginData.getUserName());
		
		if(!opt.isPresent())
		{
			throw new LoginException("Invalid Login UserId");
		}
		
		Customer newCustomer = opt.get();
		
		Integer customerId = newCustomer.getCustomerId();
		Optional<CurrentUserSession> currentUserOptional=cusDao.findByUserId(customerId);
		
		if(currentUserOptional.isPresent()) {
			throw new LoginException("User Already login with this UserId");
		}
		
		if(newCustomer.getEmail().equals(loginData.getUserName()) && newCustomer.getPassword().equals(loginData.getPassword())) {
			String key = RandomString.getRandomNumberString();
			
			CurrentUserSession currentUserSession = new CurrentUserSession(customerId, key, LocalDateTime.now());
		    cusDao.save(currentUserSession);
		    
		    LoginData logData = new LoginData();
		    logData.setUserId(currentUserSession.getId());
		    logData.setUserName(loginData.getUserName());
		    logData.setPassword(loginData.getPassword());
		    loginDao.save(logData);
		    
		    return currentUserSession.toString();
		}
		else
			throw new LoginException("Invalid UserName or Password!");
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		
		Optional<CurrentUserSession> currentUserOptional= cusDao.findByUuid(key);
		
		if(!currentUserOptional.isPresent())
		{
			throw new LoginException("User has not logged in with this UserId");
		}
		
		CurrentUserSession currentUserSession =currentUserOptional.get();
		
		cusDao.delete(currentUserSession);
		
		LoginData logindata = loginDao.findByUserId(currentUserSession.getId());

        loginDao.delete(logindata);
		
        return "Logged Out......";
	}

}
