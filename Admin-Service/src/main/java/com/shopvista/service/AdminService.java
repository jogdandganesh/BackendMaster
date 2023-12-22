package com.shopvista.service;

import java.util.List;

import com.shopvista.model.User;

public interface AdminService {

	String checkCredential(String adminEmail, String password);

	List<User> getAllUser();

}
