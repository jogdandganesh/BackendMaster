package com.shopvista.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class verifyProductDto {
	
	private int userId;
	private int paymentId;
	private List<Integer> prodIds;
	private String productSize;
	private long totalQuantity;
	private Boolean availability;

}
