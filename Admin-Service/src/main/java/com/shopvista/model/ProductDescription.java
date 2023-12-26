package com.shopvista.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDescription {
	
	private int descriptionId;
	private String productSize;
	private String productColor;
	private String productBrand;
	private long totalQuantity;
	private String about;


}





