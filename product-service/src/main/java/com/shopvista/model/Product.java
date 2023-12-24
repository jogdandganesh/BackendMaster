package com.shopvista.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
    private String productCategory;
	private Boolean availability;
	private Boolean verification;
	private String subcategory;
	

	@OneToMany(cascade = CascadeType.ALL)
	 private List<ProductImages> images;
	
	@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "description_Id")
	private ProductDescription description;
	

	@OneToOne(cascade = CascadeType.ALL)
	private Manufacturer manufacturer;
	
    @OneToMany(cascade = CascadeType.ALL)
 	private List<Review> review;
	
	@OneToMany(cascade = CascadeType.ALL)
    private List<ReturnProduct> returnProduct;
    
	
	
	
}
