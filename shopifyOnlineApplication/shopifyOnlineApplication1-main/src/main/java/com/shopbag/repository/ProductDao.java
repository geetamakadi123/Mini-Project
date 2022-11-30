package com.shopbag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopbag.model.Product;



public interface ProductDao extends JpaRepository<Product, Integer>{
    
	public List<Product> findByCategory(String category);
}
