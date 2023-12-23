package com.shopvista.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopvista.dao.OrderRepository;
import com.shopvista.dao.PaymentRepository;
import com.shopvista.dto.PlaceOrderDTO;
import com.shopvista.model.Order;
import com.shopvista.model.Payment;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private PaymentRepository paymentRepository;
	
	
	

	@Override
	public List<Order> getAllOrders(int userId) {
		System.out.println("hi"+userId);
		if (orderRepository.existsByUserId(userId)) {
			List<Order> order = orderRepository.findByUserId(userId);
			System.out.println("Got All Orders");
			return order;
		} else {
			return new ArrayList<>();
		}
			
	}

	@Override
	public Order getOrderByOrderId(int orderId) {
		if (orderRepository.existsById(orderId)) {
			Order order = orderRepository.findById(orderId).get();
			return order;
		} else
			return null;

	}

	@Override
	public Order deleteOrderByOrderId(int orderId) {
		if (orderRepository.existsById(orderId)) {
			Order order = orderRepository.findById(orderId).get();
			orderRepository.deleteById(orderId);
			return order;
		} else
			return null;
	}

	@Override
	public Order placeOrder(PlaceOrderDTO orderDto) {

		Order order = new Order();
		order.setUserId(orderDto.getUserId());
		order.setProductIds(orderDto.getProdIds());

		Payment payment = new Payment();
		payment.setPaymentMode(orderDto.getPaymentMode());
		payment.setDetails(orderDto.getDetails());
		payment.setTotalAmmount(orderDto.getTotalAmmount());

		order.setPayment(payment);

		orderRepository.save(order);

		return order;
	}

}