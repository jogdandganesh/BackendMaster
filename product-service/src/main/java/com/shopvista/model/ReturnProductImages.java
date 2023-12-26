package com.shopvista.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "return_product_images")
public class ReturnProductImages {

	@Id
	private int returnProductImagesId;
	private byte[] returnProductImage;
	
	public byte[] getReturnProductImage() {
		return returnProductImage;
	}
	public void setReturnProductImage(byte[] returnProductImage) {
		this.returnProductImage = returnProductImage;
	}
	
}
