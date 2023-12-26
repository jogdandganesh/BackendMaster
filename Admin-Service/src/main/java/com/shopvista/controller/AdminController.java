package com.shopvista.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	//==========================****Login Work****=======================================================
	@GetMapping("/get")
	public String check()
	{
		return "Running";
	}

	//API Working 
	@PostMapping("/admin/{adminEmail},{password}")
	public ResponseEntity<String> name(@PathVariable String adminEmail, @PathVariable String password  ) {
	String msg=adminService.checkCredential(adminEmail, password);	
	return ResponseEntity.status(HttpStatus.OK).body(msg);
	}
	
	//============================****User Work****=======================================================
	
	//API Working 
	@GetMapping("/admin/user")
	public ResponseEntity<List<User>> getAllUser()
	{
		return userClient.getAllUsers();
	}
	
	//========================****Category Work****=======================================================
	//API Working
	@PostMapping("/admin/category")
	public ResponseEntity<String> addCategory(@RequestBody Category category)
	{
		String msg =adminService.addCategory(category);
		return ResponseEntity.status(HttpStatus.CREATED).body(msg);
	}
	
	//API Working
	@GetMapping("admin/categories")
	public ResponseEntity<List<Category>> getCategory(){
		List<Category> categoryList=adminService.getCategory();
		return ResponseEntity.status(HttpStatus.OK).body(categoryList);
	}
	
	//API Working
	@DeleteMapping("admin/category/{categoryId}")
	public ResponseEntity<String> deleteCategory(@PathVariable int categoryId)
	{
		String msg=adminService.deleteCategory(categoryId);
		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}
	
	
	//=========================================****Product Works****=====================================
	
	//API Working
	@GetMapping("/admin/products")
	public ResponseEntity<List<Product>> getAllProduct()
	{
		
		List<Product> allProduct = productClient.getAllProduct();
		return ResponseEntity.status(HttpStatus.OK).body(allProduct);
		
		
	}
	
	//API Working
	@GetMapping("/products/{productCategory}")
	public ResponseEntity<List<Product>> sortProductByCategoeyWise(@PathVariable String productCategory)
	{
		List<Product> allProductByCategory = productClient.getAllProductByCategory(productCategory);
		return ResponseEntity.status(HttpStatus.OK).body(allProductByCategory);		
	}
	
	//API Working
	@GetMapping("/products/category")
	public ResponseEntity<Category> addProductsInCategory(@RequestBody Category category)
	{
	List<Product> allProductByCategory = productClient.getAllProductByCategory(category.getCategoryName());
		category.setProductList(allProductByCategory);
		
		return ResponseEntity.status(HttpStatus.OK).body(category);
	}
	
	
	
	
	
	
	
}
