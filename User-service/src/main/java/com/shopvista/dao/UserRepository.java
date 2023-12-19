package com.shopvista.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopvista.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmailAndPassword(String email,String password);
}
