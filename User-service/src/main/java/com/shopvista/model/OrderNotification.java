package com.shopvista.model;

import lombok.Data;

@Data
public class OrderNotification {

	private int notificationId;
	private int userId;
	private int productId;
	private int orderId;
	private String notificationFrom;
	private String notificationTo;
	private String msg;

}
