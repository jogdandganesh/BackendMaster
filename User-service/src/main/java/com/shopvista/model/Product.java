package com.shopvista.model;

import lombok.Data;
 
@Data
public class Product {
	
	private int productId;
	private String productName;
	private double productPrice;
	private String productCategory;
	private boolean availability;
	private boolean verification;
	private String subCategory;
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<ProductImages> productImages;
//	@OneToOne(cascade = CascadeType.ALL)
//	private ProductDescription description;
//	@OneToOne(cascade = CascadeType.ALL)
//	private Manufacturer manufacturer;
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Review> productReview;

}
