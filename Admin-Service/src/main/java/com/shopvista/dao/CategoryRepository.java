package com.shopvista.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopvista.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
}
