package com.shopvista.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaceOrderDTO {

	private int userId;

	private List<Integer> prodIds;

	private int paymentId;
	
	private String paymentMode;
	
	private int orderId;
	
	private double totalAmmount;
	
	private String details;

}
