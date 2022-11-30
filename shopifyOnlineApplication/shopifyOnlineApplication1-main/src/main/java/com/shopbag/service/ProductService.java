package com.shopbag.service;

import java.util.List;

import com.shopbag.exception.CustomerException;
import com.shopbag.exception.ProductException;
import com.shopbag.model.AdminProductDto;
import com.shopbag.model.ProductDTO;



public interface ProductService {

	public AdminProductDto addProduct(AdminProductDto product, String key) throws CustomerException;
	
	public AdminProductDto updateProduct(AdminProductDto product,String key) throws ProductException,CustomerException;
	
	public ProductDTO removeProduct(Integer productId,String key)throws ProductException,CustomerException;
	
	public ProductDTO viewProduct(Integer productId)throws ProductException;
	
	public List<ProductDTO> viewProductByCategory(String category) throws ProductException;
	
	public List<ProductDTO> viewAllProduct() throws ProductException;
	
	
}
