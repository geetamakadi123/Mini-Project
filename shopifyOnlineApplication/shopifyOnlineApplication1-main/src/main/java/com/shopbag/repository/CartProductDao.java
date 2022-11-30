package com.shopbag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shopbag.model.CartProduct;



public interface CartProductDao extends JpaRepository<CartProduct, Integer>{
    
	@Query("select c from CartProduct c where c.cartId=?1")
	public List<CartProduct> getByCartId(Integer cartId);
	
}
