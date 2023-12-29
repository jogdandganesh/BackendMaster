package com.shopvista.model;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
@Entity
@Data
@NoArgsConstructor
public class Product {

	@Id
	private int productId;
	private String productName;
	private double productPrice;
    private Boolean availability;
	private Boolean verification;
	private String categoryName;
	private String subCategory;
	
	
	
	//@OneToMany(cascade = CascadeType.ALL)
	 //private List<ProductImages> imageList;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ProductDescription productDescription;
	

	@OneToOne(cascade = CascadeType.ALL)
	private Manufacturer manufacturer;
	
    @OneToMany(cascade = CascadeType.ALL)
 	private List<Review> review;
	
	@OneToMany(cascade = CascadeType.ALL)
    private List<ReturnProduct> returnProduct;
    
	
	
	
}
