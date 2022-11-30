package com.shopbag.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopbag.model.Cart;
import com.shopbag.model.Customer;




public interface CartDao extends JpaRepository<Cart, Integer>{

	
	public Optional<Cart> findByCustomer(Customer customer);
	
	
}
