package com.shopvista.dto;

import com.shopvista.model.ProductImages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifyProductDto {
	
	private String productName;
	private double productPrice;
	private Boolean availability;
	private Boolean verification;
	private ProductImages imgs;
	private String productSize;
	private String productColor;
	private String productBrand;
	private int manufacturerId;

}
