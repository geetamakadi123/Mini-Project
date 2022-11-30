package com.shopbag.service;

import java.util.List;

import com.shopbag.exception.CustomerException;
import com.shopbag.exception.ProductException;
import com.shopbag.model.CartDTO;
import com.shopbag.model.ProductDTO;



public interface CartService {

	public CartDTO addProduct(Integer productId, Integer quantity,String key) throws CustomerException, ProductException;
	
	public CartDTO removeProduct(String key, Integer productId) throws CustomerException, ProductException;
	
	public CartDTO updateProductQuantity(String key, Integer productId, Integer quantity) throws CustomerException, ProductException;
	
	public CartDTO removeAllProduct(String key) throws CustomerException, ProductException;
	
	public List<ProductDTO> viewAllProduct(String key) throws CustomerException, ProductException;
	
}
