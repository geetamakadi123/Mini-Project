package com.shopbag.service;

import java.util.List;

import com.shopbag.exception.CustomerException;
import com.shopbag.exception.OrderException;
import com.shopbag.model.OrderDTO;


public interface OrderService {

	public OrderDTO addOrder(String key) throws OrderException, CustomerException;
	
	public OrderDTO viewOrder(String key, Integer orderId) throws OrderException, CustomerException;
	
	public List<OrderDTO> listOfOrder(String key) throws OrderException, CustomerException;
	
	public List<OrderDTO> listOfOrderByCustomerId(Integer customerId)throws OrderException, CustomerException;
	
	
	
}
