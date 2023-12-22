package com.shopvista.service;

import java.util.List;

import com.shopvista.dto.UserDto;
import com.shopvista.model.User;

public interface UserService {
	
	User saveUserData(UserDto user);
	
	List<User> getAllUserData();

	Object updateUserData(UserDto user);

	Object deleteUserData(int userId);

	String loginCheck(String email, String password);

}
