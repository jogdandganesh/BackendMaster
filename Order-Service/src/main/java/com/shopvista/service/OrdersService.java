package com.shopvista.service;

import java.util.List;

import com.shopvista.dto.PlaceOrderDTO;
import com.shopvista.model.Order;

public interface OrdersService {

	Order getAllOrders(int userId);

	Order getOrderByOrderId(int orderId);

	Order deleteOrderByOrderId(int orderId);

	Order placeOrder(PlaceOrderDTO order);

}
