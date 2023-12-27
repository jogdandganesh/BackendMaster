package com.shopvista.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	private String categoryName;
	private String subCategory;
	
	
	//private List<ProductImages> imageList; 
	
	@OneToOne
	private ProductDescription  productDescription;
	@OneToOne
	private Manufacturer manufacturer;
	@OneToMany
	private List<Review> review;


}






