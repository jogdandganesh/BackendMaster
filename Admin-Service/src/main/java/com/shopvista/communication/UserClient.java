package com.shopvista.communication;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.shopvista.model.User;

@FeignClient(url="http://localhost:8080/user-service", value = "user-client")
public interface UserClient {
	
	@GetMapping("/users")
	public ResponseEntity <List<User>> getAllUsers();
	
	

}
