package com.shopvista.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopvista.communication.ProductClient;
import com.shopvista.communication.UserClient;
import com.shopvista.dao.CategoryRepository;
import com.shopvista.dto.AddProductsInCategoryDto;
import com.shopvista.dto.VerifyProductDto;
import com.shopvista.model.Category;
import com.shopvista.model.Product;
import com.shopvista.model.User;
import com.shopvista.service.AdminService;

@RestController
@RequestMapping("admin-service")
public class AdminController {
	
	@Autowired
	public AdminService adminService;
	
	@Autowired
	private UserClient userClient;
	
	@Autowired
	private ProductClient productClient;
	
	@GetMapping("/get")
	public String check()
	{
		return "Running";
	}

	//APi Working 
	@PostMapping("/admin/{adminEmail},{password}")
	public ResponseEntity<String> name(@PathVariable String adminEmail, @PathVariable String password  ) {
	String msg=adminService.checkCredential(adminEmail, password);	
	return ResponseEntity.status(HttpStatus.OK).body(msg);
	}
	
	//APi Working 
	@GetMapping("/admin/user")
	public ResponseEntity<List<User>> getAllUser()
	{
		return userClient.getAllUsers();
	}
	
	//API Working
	@PostMapping("/admin/category")
	public ResponseEntity<String> addCategory(@RequestBody Category category)
	{
		String msg =adminService.addCategory(category);
		return ResponseEntity.status(HttpStatus.CREATED).body(msg);
	}
	
	
	
	
	//API Working
	@GetMapping("/admin/products")
	public ResponseEntity<List<Product>> getAllProduct()
	{
		List<Product> allProduct = productClient.getAllProduct();
		//allProduct.stream().allMatch(AdminController::verifyProduct).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(allProduct);
		
	}
	
	//API Working
	@GetMapping("/products/{productCategory}")
	public ResponseEntity<List<Product>> sortProductByCategoeyWise(@PathVariable String productCategory)
	{
		return productClient.getAllProductByCategory(productCategory);
		
	}
	
	
	@PostMapping("/products/category")
	public ResponseEntity<Category> addProductsInCategory(@RequestBody AddProductsInCategoryDto addProductsDto)
	{
		ResponseEntity<List<Product>> sortProductByCategoeyWise = this.sortProductByCategoeyWise(addProductsDto.getCategoryName());
		List<Product> list = adminService.addProductsInCategory(addProductsDto);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	
}
