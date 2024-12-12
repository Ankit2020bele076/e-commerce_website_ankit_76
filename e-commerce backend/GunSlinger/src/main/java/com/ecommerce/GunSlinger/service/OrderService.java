package com.ecommerce.GunSlinger.service;

import java.util.List;

import com.ecommerce.GunSlinger.exception.OrderException;
import com.ecommerce.GunSlinger.model.Address;
import com.ecommerce.GunSlinger.model.Order;
import com.ecommerce.GunSlinger.model.User;

public interface OrderService {
	
	public Order createOrder(User user, Address shippingAddress);
	
	public Order findOrderById(Long orderId) throws OrderException;
	
	public List<Order> usersOrderHistory(Long userId);
	
	public Order placedOrder(Long orderId) throws OrderException;
	
	public Order confirmedOrder(Long orderId) throws OrderException;
	
	public Order shippedOrder(Long orderId) throws OrderException;
	
	public Order deliveredOrder(Long orderId) throws OrderException;
	
	public Order cancelledOrder(Long orderId) throws OrderException;
	
	public List<Order> getAllOrders(User user);
	
	public void deleteOrder(Long orderId) throws OrderException;
	
}
