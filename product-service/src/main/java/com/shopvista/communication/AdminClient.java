package com.shopvista.communication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.shopvista.model.Product;

@FeignClient(url="http://localhost:8086/admin-service", value = "admin-service")
public interface AdminClient {
	
	@PostMapping("/product/verified")
	public Product getverifiedProduct(@RequestBody Product product);
}
