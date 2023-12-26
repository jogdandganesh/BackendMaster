package com.shopvista.service;

import java.util.List;

import com.shopvista.dto.ProductDTO;
import com.shopvista.model.Product;

public interface ProductService {

	Object saveProduct(ProductDTO productDescDto);
	
	Product deleteProduct(int productId);

	Product getProduct(int productId);

	List<Product> getAllProduct();

	List<Product> getProductsByCategory(String productCategory);

	List<Product> findProductBySubCategory(String subcategory);

	List<Product> getProductByName(String name);

	public	String verifyProduct(int productId);

}