package com.shopvista.dto;

import lombok.Data;

@Data
public class UserDto {

	private int userId;
	private String email;
	private String password;
	private int pincode;
	private String street;
	private String city;
	private String state;
	private String landmark;
	private String flatNo;
	private String apartment;
}
