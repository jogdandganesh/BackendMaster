package com.shopvista.communication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url="http://localhost:8086/admin-service", value = "admin-service")
public interface AdminClient {
	
	@GetMapping("/product/verified")
	public void getverifiedProduct();

}
