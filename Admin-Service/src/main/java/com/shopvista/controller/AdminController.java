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

import com.fasterxml.jackson.databind.introspect.AnnotationCollector;
import com.shopvista.communication.ProductClient;
import com.shopvista.communication.UserClient;

import com.shopvista.dto.AddProductsInCategoryDto;
import com.shopvista.dto.VerifyProductDto;

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
	
	
	
	//=========================================****Product Works****=====================================
	
	//API Working
	@GetMapping("/admin/products")
	public ResponseEntity<List<Product>> getAllProduct()
	{
		
		List<Product> allProduct = productClient.getAllProduct();
		return ResponseEntity.status(HttpStatus.OK).body(allProduct);
		
		
	}
	
	//API Working
	@GetMapping("/products/{categoryName}")
	public ResponseEntity<List<Product>> sortProductByCategoeyWise(@PathVariable String categoryName)
	{
		List<Product> allProductByCategory = productClient.getAllProductByCategory(categoryName);
		return ResponseEntity.status(HttpStatus.OK).body(allProductByCategory);		
	}
	
	//API Working
		@GetMapping("/product/{subCategory}")
		public ResponseEntity<List<Product>> sortProductBySubCategoeyWise(@PathVariable String subCategory)
		{
			List<Product> allProductByCategory = productClient.getALlProductBySubCategory(subCategory);
			return ResponseEntity.status(HttpStatus.OK).body(allProductByCategory);		
		}
	
		@GetMapping("product/verify")
		public List<Product> verifyProduct()
		{
			List<Product> productList = productClient.getAllProduct();
			System.out.println(productList);
			List<Product> verifiedList = productList.stream().filter(p->p.getProductDescription().getProductBrand()!=null && p.getProductDescription().getProductColor()!=null &&  (p.getProductDescription().getProductSize()!=null && !p.getProductDescription().getProductSize().isEmpty())
					&& p.getAvailability()==true && p.getProductPrice()!=0.0d).collect(Collectors.toList());
			
			return verifiedList;
		}
		
		@GetMapping("/product/verified")
		public List<Product> getverifiedProduct()
		{
			List<Product> verifiedProduct = this.verifyProduct();
			for(Product prod:verifiedProduct)
			{
				prod.setVerification(true);
			}
			return verifiedProduct;
		}
		
	
	
	
	
	
	
	
}
