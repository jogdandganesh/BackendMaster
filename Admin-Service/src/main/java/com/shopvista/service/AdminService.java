package com.shopvista.service;

import java.util.List;

import com.shopvista.dto.VerifyProductDto;
import com.shopvista.model.Category;
import com.shopvista.model.User;

public interface AdminService {

	String checkCredential(String adminEmail, String password);

	String addCategory(Category category);

	Boolean verifyProduct(VerifyProductDto verifyProductDto);
	

}
