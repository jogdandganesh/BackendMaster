package com.shopvista.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopvista.dao.UserAddressRepository;
import com.shopvista.dao.UserRepository;
import com.shopvista.dto.UserDto;
import com.shopvista.model.User;
import com.shopvista.model.UserAddress;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private UserAddressRepository addressRepository;

	@Override
	public User saveUserData(UserDto user) {
		if (user != null) {
			UserAddress address = mapper.map(user, UserAddress.class);
			User userData = mapper.map(user, User.class);;
			User usr = repository.save(userData);
			addressRepository.save(address);
			return usr;
		} else
			return new User();
	}

	@Override
	public List<User> getAllUserData() {
		List<User> userList = repository.findAll();
		if (userList.isEmpty())
			return new ArrayList<>();
		else
			return userList;
	}

	@Override
	public Object updateUserData(UserDto user) {
		if (user != null) {
			User userData = mapper.map(user, User.class);
			UserAddress address = mapper.map(user, UserAddress.class);
			User usr = repository.save(userData);
			UserAddress userAddress = addressRepository.save(address);
			return usr;
		} else
			return "Data Not Updated";
	}

	@Override
	public Object deleteUserData(int userId) {
		if (repository.existsById(userId)) {
			Optional<User> user = repository.findById(userId);
			repository.delete(user.get());
			return user.get();
		}
		else
			return "Bad request Id Does Not exist";

	}

	@Override
	public String loginCheck(String email, String password) {
		User user = repository.findByEmailAndPassword(email, password);
		if(user!=null)
		return "Login Succesfull";
		else
			return "Invalid credentials";
	}

}
