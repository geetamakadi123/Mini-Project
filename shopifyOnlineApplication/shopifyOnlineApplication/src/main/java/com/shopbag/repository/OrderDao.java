package com.shopbag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopbag.model.Customer;
import com.shopbag.model.Order;



public interface OrderDao extends JpaRepository<Order, Integer>{

	public List<Order> findByCustomers(Customer customers);
}
