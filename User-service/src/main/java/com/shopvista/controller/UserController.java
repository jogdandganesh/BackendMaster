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

import com.shopvista.dto.UserDto;
import com.shopvista.model.User;
import com.shopvista.service.UserService;

@RestController
@RequestMapping("/user-service")
public class UserController {
	
	@Autowired
	private UserService userServ;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> userList = userServ.getAllUserData();
		return ResponseEntity.status(HttpStatus.OK).body(userList);
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody UserDto user){
		User userData = userServ.saveUserData(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userData);
	}
	
	@PutMapping("/user")
	public ResponseEntity<Object> updateUser(@RequestBody UserDto user){
		Object data = userServ.updateUserData(user);
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Object> deleteUser(@PathVariable int userId){
		Object user = userServ.deleteUserData(userId);		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@PostMapping("/{email},{password}")
	public ResponseEntity<String> userLogin(@PathVariable String email,@PathVariable String password){
		String loginCheck = userServ.loginCheck(email,password);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(loginCheck);
		
	}
	
	
	
}
