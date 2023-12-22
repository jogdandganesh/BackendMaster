package com.shopvista.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserAddress {
	@Id
	private long pincode;
	private String street;
	private String city;
	private String state;
	private String landmark;
	private String flatNo;
	private String apartment;

}
