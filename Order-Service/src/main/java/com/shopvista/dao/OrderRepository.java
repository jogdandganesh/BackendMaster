package com.shopvista.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopvista.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>  {
	
	public List<Order> findByUserId(int userId);
	
	public boolean existsByUserId(int userId);

}
