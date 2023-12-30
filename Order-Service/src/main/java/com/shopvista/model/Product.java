package com.shopvista.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
	
	@Id
	private int productId;
	private String productName;
	private double productPrice;
	private String categoryName;
	private Boolean availability;
	private Boolean verification;
	private String subCategory;


}
