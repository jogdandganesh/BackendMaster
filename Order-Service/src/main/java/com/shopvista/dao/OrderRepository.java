package com.shopvista.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopvista.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>  {
	
	public Order findByUserId(int userId);
	
	public boolean existsByUserId(int userId);

}
