package com.shopbag.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopbag.model.Customer;


public interface CustomerDao extends JpaRepository<Customer,Integer>{

	public Optional<Customer> findByEmail(String email);
}
