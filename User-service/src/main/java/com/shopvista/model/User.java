package com.shopvista.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class User {
	@Id
	private int userId;
	private String email;
	private String password;
	private int orderId;
	private int cartId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private UserAddress adr;
}
