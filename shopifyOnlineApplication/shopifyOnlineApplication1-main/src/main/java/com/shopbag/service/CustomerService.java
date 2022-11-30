package com.shopbag.service;

import java.util.List;

import com.shopbag.exception.CustomerException;
import com.shopbag.model.Customer;
import com.shopbag.model.CustomerDTO;



public interface CustomerService {

	public CustomerDTO addCustomer(Customer customer) throws CustomerException;
	
	public CustomerDTO updateCustomer(Customer customer) throws CustomerException;
	
	public CustomerDTO removeCustomer(String email) throws CustomerException;
	
	public CustomerDTO viewCustomer(String email) throws CustomerException;
	
	public List<CustomerDTO> viewAllCustomer() throws CustomerException;
	
	
}
