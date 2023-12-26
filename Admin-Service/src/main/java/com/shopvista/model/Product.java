package com.shopvista.model;

import java.util.List;

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
	private Boolean availability;
	private Boolean verification;
	
	private Category category;
	private List<ProductImages> imageList; 
	private ProductDescription  productDescription;
	private Manufacturer manufacturer;
	private List<Review> review;


}






