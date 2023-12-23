package com.shopvista.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Entity
@Data
public class Review {

	@Id
	private int ratingId;
	private int userId;
	private String review;
	@Lob
	private byte[] productImages;
	
}
