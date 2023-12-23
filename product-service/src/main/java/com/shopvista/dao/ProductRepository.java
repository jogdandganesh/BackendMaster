package com.shopvista.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopvista.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

//public List<ProductDTO> findByProductCategory(String productCategory);


	public List<Product> findByProductCategory(String productCategory);

	public boolean existsBySubcategory(String subcategory);
	
	public List<Product> findBySubcategory(String subcategory);

	public boolean existsByProductName(String name);

	public List<Product> findByProductName(String name);
	
	
	
	}

