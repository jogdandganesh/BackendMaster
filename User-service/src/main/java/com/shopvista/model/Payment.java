package com.shopvista.model;

import lombok.Data;

@Data
public class Payment {

	private int paymentId;
	private String paymentMode;
	private int orderId;
	private double totalAmount;
//	@OneToOne(cascade = CascadeType.ALL)
//	private BankDetails details;

}
