package com.shopvista.model;

import lombok.Data;

@Data
public class Orders {
	
	private int orderId;
	private int userId;
//	@ManyToMany(cascade = CascadeType.ALL)
//	private List<Product> prod;
//	@OneToOne(cascade = CascadeType.ALL)
//	private Payment payment;
//	@OneToMany(cascade = CascadeType.ALL)
//	private OrderNotification notification;


}
