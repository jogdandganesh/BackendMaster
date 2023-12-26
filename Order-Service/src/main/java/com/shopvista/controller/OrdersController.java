package com.shopvista.controller;

import java.util.List;


import org.bouncycastle.asn1.ocsp.ResponderID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopvista.OrderServiceApplication;
import com.shopvista.dto.PlaceOrderDTO;
import com.shopvista.model.Order;
import com.shopvista.service.OrdersService;

import ch.qos.logback.core.status.Status;

@RestController
@RequestMapping("order-service")
public class OrdersController {
	
	@Autowired
	private OrdersService orderService;
	
	
	@GetMapping("/get")
	public String check()
	{
		return "Running";
	}
	
	

	@GetMapping("/order/user/{userId}")
	public ResponseEntity<Object> getAllOrdersOfUsers(@PathVariable int userId)
	{
		System.out.println(userId);
		List<Order> allOrders=orderService.getAllOrders(userId);
		
		if(!allOrders.isEmpty()) 
		return new ResponseEntity<>(allOrders, HttpStatus.FOUND);
		
		else
			return new ResponseEntity<>("Orders not found with given userId", HttpStatus.NOT_FOUND);
			
	}
	
	@GetMapping("/order/{orderId}")
	public ResponseEntity<Object> getOrderByOrderId(@PathVariable int orderId)
	{
		Order order=orderService.getOrderByOrderId(orderId);
		if(order!=null)
		return new ResponseEntity<Object>(order, HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("Order not found with given OrderId", HttpStatus.NOT_FOUND);
			
	}
	
	@DeleteMapping("/order/{orderId}")
	public ResponseEntity<String> deleteOrderByOrderId(@PathVariable int orderId)
	{
		Order order=orderService.deleteOrderByOrderId(orderId);
		if(order!=null)
		return new ResponseEntity<>("Deleted", HttpStatus.FOUND);
		else
			return new ResponseEntity<>("Order not Found with given orderId", HttpStatus.NOT_FOUND);
			
	}
	
	
	@PostMapping("/order")
	public ResponseEntity<Order> placeOrder(@RequestBody PlaceOrderDTO order)
	{
		Order orders=orderService.placeOrder(order);
		return ResponseEntity.status(HttpStatus.CREATED).body(orders);
	}
	
	
}
