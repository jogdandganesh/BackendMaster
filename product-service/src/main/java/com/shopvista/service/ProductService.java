package com.shopvista.service;

import java.util.List;

import com.shopvista.dto.ProductDTO;
import com.shopvista.model.Product;

public interface ProductService {

	

	Product getProduct(int productId);

	Product deleteProduct(int productId);

//	productDescription:::

	Object saveProduct(ProductDTO productDescDto);

	List<Product> getAllProduct();

	List<Product> getProductsByCategory(String productCategory);

	List<Product> findProductBySubCategory(String subcategory);

	List<Product> getProductByName(String name);

	Product updateProduct(Product product);

}