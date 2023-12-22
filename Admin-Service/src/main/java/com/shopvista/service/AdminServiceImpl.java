package com.shopvista.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopvista.communication.UserClient;

import com.shopvista.dao.AdminRepository;
import com.shopvista.model.User;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	public AdminRepository adminRepository;
	
	@Autowired
	public UserClient userClient; 

	@Override
	public String checkCredential(String adminEmail, String password) {
		System.out.println(adminEmail+"  "+password);
		if(adminEmail.equals(adminEmail) && password.equals(password))
		{
			System.out.println(adminEmail+"  "+password);
			return "LoginSucessfull";
		}
		else
		return "LoginFail";
	}

	@Override
	public List<User> getAllUser() {
		List<User> userList = userClient.getAllUsers();
		return userList;
	}

}
