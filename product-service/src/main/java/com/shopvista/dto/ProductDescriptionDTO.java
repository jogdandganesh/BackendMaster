package com.shopvista.dto;

import lombok.Data;

@Data
public class ProductDescriptionDTO{

	private int descriptionId;
	private String productSize;
	private String productColor;
	private String productBrand;
	private long totalQuantity;
	private String about;
}
