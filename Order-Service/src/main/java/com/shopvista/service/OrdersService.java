package com.shopvista.service;

import java.util.List;

import com.shopvista.dto.PlaceOrderDTO;
import com.shopvista.model.Order;
import com.shopvista.model.Product;

public interface OrdersService {

	List<Order> getAllOrders(int userId);

	Order getOrderByOrderId(int orderId);

	Order deleteOrderByOrderId(int orderId);

	Order placeOrder(PlaceOrderDTO order);

	List<Product> getAllProductsByOrderId(int orderId);

	

}
