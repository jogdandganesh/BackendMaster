package com.shopvista.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopvista.dto.ProductDTO;
import com.shopvista.model.Product;
import com.shopvista.service.ProductService;

@RestController
@RequestMapping("/product-service")
public class ProductController {

	@Autowired
	private ProductService productService;

	// get product
	// ........................................................................
	@GetMapping("/{ProductId}")
	public ResponseEntity<Object> getProduct(@PathVariable int ProductId) {
		Product product = productService.getProduct(ProductId);
		if (product != null) {
			return new ResponseEntity<Object>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("ProductId is not Found" + ProductId, HttpStatus.BAD_REQUEST);
		}
	}

	// delete product
	// .........................................................................

	@DeleteMapping("/{ProductId}")
	public ResponseEntity<Product> deleteProduct(@PathVariable int ProductId) {
		return new ResponseEntity<Product>(productService.deleteProduct(ProductId), HttpStatus.OK);
	}

	// update product
	// .............................................................................

	@PutMapping("/product")
	public ResponseEntity<Object> updateProduct(@RequestBody ProductDTO product) {
		productService.saveProduct(product);
		return new ResponseEntity<Object>("Product Status Updated", HttpStatus.ACCEPTED);
	}

	// productDTO.....................................................................
	@PostMapping("/product")
	public ResponseEntity<Object> saveProduct(@RequestBody ProductDTO product) {
		Object productData = productService.saveProduct(product);
		return ResponseEntity.status(HttpStatus.FOUND).body(productData);
	}

	// get all product.............................................................
	@GetMapping("/products")
	public List<Product> getAllProduct() {
		return productService.getAllProduct();

	}

	

	//Product_Category here......................................................................
	@GetMapping("/product/category/{productCategory}")
	public ResponseEntity<List<Product>> getAllProductByCategory(@PathVariable String productCategory) {
		List<Product> list = productService.getProductsByCategory(productCategory);
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	@GetMapping("/product/{subcategory}")
	public ResponseEntity<List<Product>> getALlProductBySubCategory(@PathVariable String subcategory) {
		List<Product> productList = productService.findProductBySubCategory(subcategory);
		return ResponseEntity.status(HttpStatus.OK).body(productList);
	}

	@GetMapping("/products/{name}")
	public ResponseEntity<List<Product>> getProductByNameLike(@PathVariable String name) {
		List<Product> productList = productService.getProductByName(name);
		return ResponseEntity.status(HttpStatus.OK).body(productList);
	}
	
	
	//Product_Verification here..................................................................................
	@PostMapping("/verify/{productId}")
	public ResponseEntity<String> productVerification(@PathVariable int productId){
		String message = productService.verifyProduct(productId);
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	
	
	
}
