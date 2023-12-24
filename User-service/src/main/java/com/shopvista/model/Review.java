package com.shopvista.model;

import lombok.Data;

@Data
public class Review {

	private int ratingId;
	private int userId;
	private String review;
	private byte[] reviewImages;
}
