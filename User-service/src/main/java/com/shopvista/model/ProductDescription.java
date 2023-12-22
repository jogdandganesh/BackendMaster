package com.shopvista.model;

import lombok.Data;

@Data
public class ProductDescription {

	private int descriptionId;
	private String productSize;
	private String productColor;
	private String productBrand;
	private long totalQuantity;
	private String about;
}
