package com.ecommerce.GunSlinger.service;

import com.ecommerce.GunSlinger.exception.ProductException;
import com.ecommerce.GunSlinger.model.Cart;
import com.ecommerce.GunSlinger.model.User;
import com.ecommerce.GunSlinger.request.AddItemRequest;

public interface CartService {
	
	public Cart createCart(User user);
	
	public String addCartItem(Long userId, AddItemRequest req) throws ProductException;
	
	public Cart findUserCart(Long userId);
	
}
