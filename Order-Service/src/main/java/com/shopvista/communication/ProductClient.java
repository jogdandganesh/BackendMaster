package com.shopvista.communication;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.shopvista.model.Product;

@FeignClient(url = "http://localhost:8085/product-service", value = "product-client")
public interface ProductClient {

	@GetMapping("/products")
	public  List<Product> getAllProduct();
}
