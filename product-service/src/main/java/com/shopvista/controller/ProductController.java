package com.shopvista.controller;

import java.util.List;
import java.util.stream.Collectors;

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

	@GetMapping("/{ProductId}")
	public Product getProduct(@PathVariable int ProductId) {
		Product product = productService.getProduct(ProductId);
		return product;
	}

	@DeleteMapping("/{ProductId}")
	public ResponseEntity<Product> deleteProduct(@PathVariable int ProductId) {
		return new ResponseEntity<Product>(productService.deleteProduct(ProductId), HttpStatus.OK);
	}

	@PutMapping("/product")
	public ResponseEntity<Object> updateProduct(@RequestBody ProductDTO product) {
		productService.saveProduct(product);
		return new ResponseEntity<Object>("Product Status Updated", HttpStatus.ACCEPTED);
	}

	@PostMapping("/product")
	public ResponseEntity<Object> saveProduct(@RequestBody ProductDTO product) {
		Object productData = productService.saveProduct(product);
		return ResponseEntity.status(HttpStatus.FOUND).body(productData);
	}

	@GetMapping("/products")
	public List<Product> getAllProduct() {
		return productService.getAllProduct();

	}

	@GetMapping("/product/category/{categoryName}")
	public List<Product> getAllProductByCategory(@PathVariable String categoryName) {
		return productService.getProductsByCategory(categoryName);
	}

	@GetMapping("/product/{subCategory}")
	public List<Product> getALlProductBySubCategory(@PathVariable String subCategory) {
		List<Product> subcategoryList = productService.findProductBySubCategory(subCategory);
		return subcategoryList;
	}

	@GetMapping("/products/{name}")
	public ResponseEntity<List<Product>> getProductByNameLike(@PathVariable String name) {
		List<Product> productList = productService.getProductByName(name);
		return ResponseEntity.status(HttpStatus.OK).body(productList);
	}

	@PutMapping("/verify/product")
	public Product verifyProduct(@RequestBody Product product) {
		Product verifiedProduct = productService.verifyProduct(product);
		return verifiedProduct;
	}

	@GetMapping("/product/name/{ch}")
	public List<Product> getProductByNameStartsWith(@PathVariable String ch) {
		List<Product> productList = productService.getProductByCharStartsWith(ch);
		return productList;
	}

	@GetMapping("/products/category/{category}")
	public List<Product> getProductCategoryNameStartsWith(@PathVariable String category) {
		List<Product> productListBySubcategory = productService.getProductByCategoryNameStartsWith(category);
		return productListBySubcategory;
	}

	@GetMapping("/subcategory/{subcategory}")
	public List<Product> getProductSubCategoryNameStartsWith(@PathVariable String subcategory) {
		List<Product> productBySubCategory = productService.getProductBySubCategory(subcategory);
		return productBySubCategory;
	}
}
