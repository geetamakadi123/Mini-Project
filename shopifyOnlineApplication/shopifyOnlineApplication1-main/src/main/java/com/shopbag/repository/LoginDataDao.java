package com.shopbag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopbag.model.LoginData;



public interface LoginDataDao extends JpaRepository<LoginData, Integer>{

	public LoginData findByUserId(Integer userId);
	
}
