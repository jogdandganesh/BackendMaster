package com.shopvista.model;

import lombok.Data;

@Data
public class Cart {

	private int cartId;
	private int userId;
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Product> product;

}
