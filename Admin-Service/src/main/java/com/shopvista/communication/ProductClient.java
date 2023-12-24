package com.shopvista.communication;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.shopvista.model.Product;

@FeignClient(url = "http://localhost:8085/product-service", value = "product-client")
public interface ProductClient {
	
	
	@GetMapping("/products")
	public  List<Product> getAllProduct();
	
	@GetMapping("/product/category/{productCategory}")
	public  ResponseEntity<List<Product>> getAllProductByCategory(@PathVariable String productCategory);
}
