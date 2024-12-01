package com.ecommerce.GunSlinger.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.GunSlinger.exception.OrderException;
import com.ecommerce.GunSlinger.exception.UserException;
import com.ecommerce.GunSlinger.model.Address;
import com.ecommerce.GunSlinger.model.Order;
import com.ecommerce.GunSlinger.model.User;
import com.ecommerce.GunSlinger.service.OrderService;
import com.ecommerce.GunSlinger.service.UserService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/")
	public ResponseEntity<Order> createOrder(@RequestBody Address shippingAddress, @RequestHeader("Authorization") String jwt) throws UserException{
		
		User user = userService.findUserProfileByJwt(jwt);
		
		Order order = orderService.createOrder(user, shippingAddress);
		
		return new ResponseEntity<>(order, HttpStatus.CREATED);
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<Order>> usersOrderHistory(@RequestHeader("Authorization") String jwt) throws UserException{
		
		User user = userService.findUserProfileByJwt(jwt);
		
		List<Order> orders = orderService.usersOrderHistory(user.getUserId());
		
		return new ResponseEntity<>(orders, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<Order> findOrderById(@PathVariable("Id") Long orderId) throws UserException, OrderException {
		
		Order order = orderService.findOrderById(orderId);
		
		return new ResponseEntity<>(order, HttpStatus.ACCEPTED);
		
	}
}
