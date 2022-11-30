package com.shopbag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopbag.model.Address;

@Repository
public interface AddressDao extends JpaRepository<Address,Integer> {

	
	
}
