package com.shopvista.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopvista.model.Admin;
import com.shopvista.model.Category;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	
	

}
