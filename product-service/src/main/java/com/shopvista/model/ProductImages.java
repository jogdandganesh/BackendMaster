package com.shopvista.model;



import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="product_images")
@NoArgsConstructor
public class ProductImages {

	public ProductImages(byte[] images) {
			}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int imageId;

	//@Lob
	//private byte[] images;

	
}
