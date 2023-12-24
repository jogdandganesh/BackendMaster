package com.shopvista.dto;

import java.util.List;

import com.shopvista.model.ProductImages;
import com.shopvista.model.ReturnProductImages;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
public class ProductDTO {

	//product class...........................
	private int productId;
	private String productName;
	private double productPrice;
	private String productCategory;
	private Boolean availability;
	private Boolean verification;
	private String subcategory;
	
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
	private String mailId;
	private String productManuCategory;
	
	//review class...............................
	private int ratingId;
	private int userId;
	private String review;
	@Lob
	private byte[] Productimages;
	
	//returnProduct class.........................
	private int productReturnId;
	private String returnReason;
//	private int productId;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ReturnProductImages> imgs;
	private String approval;
	
	//ProductImages class..........................
	private int imageId;

	@Lob
	private byte[] images;
//.................................//
	

	
	
	
}
