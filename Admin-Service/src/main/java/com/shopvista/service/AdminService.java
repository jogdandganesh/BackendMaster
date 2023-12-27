package com.shopvista.service;

import java.util.List;


import org.springframework.http.ResponseEntity;

import com.shopvista.dto.AddProductsInCategoryDto;
import com.shopvista.dto.VerifyProductDto;
import com.shopvista.model.Product;
import com.shopvista.model.User;

public interface AdminService {

	String checkCredential(String adminEmail, String password);

	//String addCategory(Category category);

	//List<Category> getCategory();

	//String deleteCategory(int categoryId);

	//List<Product> addProductsInCategory(AddProductsInCategoryDto addProductsDto);

	
	
	

}
