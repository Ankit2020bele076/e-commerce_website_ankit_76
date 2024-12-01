package com.ecommerce.GunSlinger.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.GunSlinger.model.OrderItem;
import com.ecommerce.GunSlinger.repository.OrderItemRepository;
import com.ecommerce.GunSlinger.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	
	@Autowired
	private OrderItemRepository orderItemRepo;
	
	@Override
	public OrderItem createOrderItem(OrderItem orderItem) {
		return orderItemRepo.save(orderItem);
	}

}
