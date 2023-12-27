package com.shopvista.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	private int productId;
	private String productName;
	private double productPrice;
	private String productCategory;
	private Boolean availability;
	private Boolean verification;
	private String subCategory;
	private ProductImages imgs; 
	private ProductDescription  productDescription;
	private Manufacturer manufacturer;
	private Review productReview;

}
