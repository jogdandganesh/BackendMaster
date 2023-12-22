package com.shopvista.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopvista.model.UserAddress;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long>{

}
