package com.shopvista.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
	
	private int ratingId;
	private int userId;
	private String review;
	private Byte[] images;


}




