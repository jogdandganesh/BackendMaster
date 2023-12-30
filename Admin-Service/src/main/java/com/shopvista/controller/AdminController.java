package com.shopvista.controller;

import java.util.List;


import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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
import com.shopvista.dao.AdminRepository;
import com.shopvista.dto.AddProductsInCategoryDto;
import com.shopvista.dto.ProductDto;
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
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	   @GetMapping("/get")
	   public String check(){   
		return "Running";
	}

	 
	   @PostMapping("/admin/{adminEmail},{password}")
	   public ResponseEntity<String> name(@PathVariable String adminEmail, @PathVariable String password  ) {
	   String msg=adminService.checkCredential(adminEmail, password);	
	   return ResponseEntity.status(HttpStatus.OK).body(msg);
	}
	
	 
	   @GetMapping("/admin/user")
	   public ResponseEntity<List<User>> getAllUser(){
		return userClient.getAllUsers();
	}
	
	
	   @GetMapping("/admin/products")
	   public ResponseEntity<List<Product>> getAllProduct(){
		
		List<Product> allProduct = productClient.getAllProduct();
		return ResponseEntity.status(HttpStatus.OK).body(allProduct);
		
		
	}
	
	   @GetMapping("/products/{categoryName}")
	   public ResponseEntity<List<Product>> sortProductByCategoeyWise(@PathVariable String categoryName){
		List<Product> allProductByCategory = productClient.getAllProductByCategory(categoryName);
		return ResponseEntity.status(HttpStatus.OK).body(allProductByCategory);		
	}
	
	   @GetMapping("/product/{subCategory}")
		public ResponseEntity<List<Product>> sortProductBySubCategoryWise(@PathVariable String subCategory){
			List<Product> allProductByCategory = productClient.getALlProductBySubCategory(subCategory);
			return ResponseEntity.status(HttpStatus.OK).body(allProductByCategory);		
		}
	    
		@PostMapping("product/verify")
		public Product verifyProduct(@RequestBody Product p){
			
			if(
			((p.getProductDescription().getProductBrand()!=null && !p.getProductDescription().getProductBrand().isEmpty() )
					&& (p.getProductDescription().getProductColor()!=null && !p.getProductDescription().getProductColor().isEmpty() ) &&  (p.getProductDescription().getProductSize()!=null && !p.getProductDescription().getProductSize().isEmpty())
					&& p.getAvailability()==true && p.getProductPrice()!=0.0d))
             {
	           p.setVerification(true);
	           return p;
             }
			else
				
			return new Product();
			}
		
		@GetMapping("admin/product/{productId}")
		public ResponseEntity<Object> getProductByProductId(@PathVariable int productId){
			
			return productClient.getProduct(productId);
		}
		
		@DeleteMapping("/product/{productId}")
		public ResponseEntity<Product> deleteProductByProductId(@PathVariable int productId) {
			
			return productClient.deleteProduct(productId);
			
		}
		
		@GetMapping("admin/products/{name}")
		public ResponseEntity<List<Product>> getProductByName(@PathVariable String name){
			
			return productClient.getProductByNameLike(name);
		}
		
		@GetMapping("/product/character/{ch}")
		public List<Product> getProductByNameStartsWith(@PathVariable String ch){
			return productClient.getProductByNameStartsWith(ch);
		}
		
		@GetMapping("/product/category/{category}")
		public List<Product> getProductCategoryNameStartsWith(@PathVariable String category){
			System.out.println(category);
			return  productClient.getProductCategoryNameStartsWith(category);
		}
	
	    @GetMapping("/product/subcategory/{subcategory}")
		public List<Product> getProductSubCategoryNameStartsWith(@PathVariable String subcategory){
	    	System.out.println(subcategory);
			return productClient.getProductSubCategoryNameStartsWith(subcategory);
		}
	    
			
		
	
	
	
	
}
