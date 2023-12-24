package com.shopvista.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopvista.communication.ProductClient;
import com.shopvista.communication.UserClient;

import com.shopvista.dao.AdminRepository;
import com.shopvista.dao.CategoryRepository;
import com.shopvista.dto.AddProductsInCategoryDto;
import com.shopvista.dto.VerifyProductDto;
import com.shopvista.model.Category;
import com.shopvista.model.Product;
import com.shopvista.model.User;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	public AdminRepository adminRepository;
	
	@Autowired
	public CategoryRepository categoryRepository;
	
	@Autowired
	public ProductClient productClient;
	
	@Autowired
	public ModelMapper modelMapper; 
	
	
	
	

	@Override
	public String checkCredential(String adminEmail, String password) {
		System.out.println(adminEmail+"  "+password);
		if(adminEmail.equals(adminEmail) && password.equals(password))
		{
			System.out.println(adminEmail+"  "+password);
			return "LoginSucessfull";
		}
		else
		return "LoginFail";
	}

	@Override
	public String addCategory(Category category) {
		categoryRepository.save(category);
		return "Category Added";
	}

	@Override
	public List<Product> addProductsInCategory(AddProductsInCategoryDto addProductsDto) {
		Category category=modelMapper.map(addProductsDto, Category.class);
		ResponseEntity<List<Product>> allProductByCategory = productClient.getAllProductByCategory(addProductsDto.getCategoryName());
		//category.setProductList(allProductByCategory);
		categoryRepository.save(category);
		return null;
	}

	

	
	
	

}
