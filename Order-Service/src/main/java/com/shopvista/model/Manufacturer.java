package com.shopvista.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manufacturer {
	
	private int manufacturerId;
	private String manufacturerName;
	private String manufacturerAddress;
	private String mailId;
	private String productCategory;


}





