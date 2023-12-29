package com.shopvista.communication;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.shopvista.model.Product;

@FeignClient(url = "http://localhost:8085/product-service", value = "product-client")
public interface ProductClient {
	
	
	@GetMapping("/products")
	public  List<Product> getAllProduct();
	
	@GetMapping("/product/category/{productCategory}")
	public  List<Product> getAllProductByCategory(@PathVariable String productCategory);
	
	@GetMapping("/product/{subCategory}")
	public List<Product> getALlProductBySubCategory(@PathVariable String subCategory);
	
	@GetMapping("/{ProductId}")
	public ResponseEntity<Object> getProduct(@PathVariable int ProductId);
	
	@DeleteMapping("/{ProductId}")
	public ResponseEntity<Product> deleteProduct(@PathVariable int ProductId);
	
//	@PutMapping("/product")
//	public ResponseEntity<Object> updateProduct(@RequestBody ProductDTO product);
	
	@GetMapping("/products/{name}")
	public ResponseEntity<List<Product>> getProductByNameLike(@PathVariable String name);
	
	
	
}
