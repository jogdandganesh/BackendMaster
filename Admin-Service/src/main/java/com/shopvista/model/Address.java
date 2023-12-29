package com.shopvista.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	
	private int addressId;
	private String buildingName;
	private String street;
	private String landmark;
	private String city;
	private String state;
	private long pincode;


}








