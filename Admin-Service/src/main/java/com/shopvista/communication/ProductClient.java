package com.shopvista.communication;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "http://localhost:8085/product-service")
public interface ProductClient {
	
	

}
