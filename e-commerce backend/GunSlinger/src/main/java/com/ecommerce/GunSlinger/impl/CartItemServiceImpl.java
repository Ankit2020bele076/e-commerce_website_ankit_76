package com.ecommerce.GunSlinger.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.GunSlinger.exception.CartItemException;
import com.ecommerce.GunSlinger.exception.UserException;
import com.ecommerce.GunSlinger.model.Cart;
import com.ecommerce.GunSlinger.model.CartItem;
import com.ecommerce.GunSlinger.model.Product;
import com.ecommerce.GunSlinger.model.User;
import com.ecommerce.GunSlinger.repository.CartItemRepository;
import com.ecommerce.GunSlinger.service.CartItemService;
import com.ecommerce.GunSlinger.service.UserService;

@Service
public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
	private CartItemRepository cartItemRepo;
	
	@Autowired
	private UserService userService;
	
	@Override
	public CartItem createCartItem(CartItem cartItem) {
		cartItem.setQuantity(1);
		cartItem.setPrice(cartItem.getProduct().getPrice() * cartItem.getQuantity());
		cartItem.setDiscountedPrice(cartItem.getProduct().getDiscountedPrice() * cartItem.getQuantity());
		
		CartItem createdCartItem = cartItemRepo.save(cartItem);
		
		return createdCartItem;
	}

	@Override
	public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException {
		
		CartItem item = findCartItemById(id);
		User user = userService.findUserById(item.getUserId());
		
		if(user.getUserId().equals(userId)) {
			item.setQuantity(cartItem.getQuantity());
			item.setPrice(item.getQuantity() * item.getProduct().getPrice());
			item.setDiscountedPrice(item.getQuantity() * item.getProduct().getDiscountedPrice());
		}
		
		return cartItemRepo.save(item);
		
	}

	@Override
	public CartItem isCartItemExist(Cart cart, Product product, String size, String platform, Long userId) {
		CartItem cartItem = cartItemRepo.isCartItemExist(cart, product, size, platform, userId);
		return cartItem;
	}

	@Override
	public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException {
		
		CartItem cartItem = findCartItemById(cartItemId);
		
		User user = userService.findUserById(cartItem.getUserId());
		
		User reqUser = userService.findUserById(userId);
		
		if(user.getUserId().equals(reqUser.getUserId())) {
			cartItemRepo.deleteById(cartItemId);
		}
		else {
			throw new UserException("You can't remove another user's item");
		}
		
	}

	@Override
	public CartItem findCartItemById(Long cartItemId) throws CartItemException {
		Optional<CartItem> opt = cartItemRepo.findById(cartItemId);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new CartItemException("Cart Item not found with id : "+cartItemId);
	}

}
