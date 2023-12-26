package com.shopvista.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

	//product class...........................
	private int productId;
	private String productName;
	private double productPrice;
    private Boolean availability;
	private Boolean verification;
	
	
	//productDescription class..................
	private int descriptionId;
	private String productSize;
	private String productColor;
	private String productBrand;
	private long totalQuantity;
	private String about;
	
	
	//manufacturer class.........................
	private int manufacturerId;
	private String manufacturerName;
	private String manufacturerAddress;
	private String manufactureMailId;
	
	
//.................................//
	
	
	private String categoryName;
	private String subCategory;
	

	
	
	
}
