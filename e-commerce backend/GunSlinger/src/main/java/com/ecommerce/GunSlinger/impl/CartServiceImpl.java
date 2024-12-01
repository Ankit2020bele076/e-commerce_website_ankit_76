package com.ecommerce.GunSlinger.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.GunSlinger.exception.ProductException;
import com.ecommerce.GunSlinger.model.Cart;
import com.ecommerce.GunSlinger.model.CartItem;
import com.ecommerce.GunSlinger.model.Product;
import com.ecommerce.GunSlinger.model.User;
import com.ecommerce.GunSlinger.repository.CartRepository;
import com.ecommerce.GunSlinger.request.AddItemRequest;
import com.ecommerce.GunSlinger.service.CartItemService;
import com.ecommerce.GunSlinger.service.CartService;
import com.ecommerce.GunSlinger.service.ProductService;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ProductService productService;

	@Override
	public Cart createCart(User user) {
		Cart cart = new Cart();
		cart.setUser(user);
		return cartRepo.save(cart);
	}

	@Override
	public String addCartItem(Long userId, AddItemRequest req) throws ProductException {
		Cart cart = cartRepo.findByUserId(userId);
		Product product = productService.findProductById(req.getProductId());
		CartItem isPresent = cartItemService.isCartItemExist(cart, product, req.getSize(), userId);
		
		if(isPresent == null) {
			CartItem cartItem = new CartItem();
			cartItem.setProduct(product);
			cartItem.setCart(cart);
			cartItem.setQuantity(req.getQuantity());
			cartItem.setUserId(userId);
			
			int price = req.getQuantity() * product.getDiscountedPrice();
			cartItem.setPrice(price);
			cartItem.setSize(req.getSize());
			
			CartItem createdCartItem = cartItemService.createCartItem(cartItem);
			cart.getCartItems().add(createdCartItem);
		}
		
		return "Item Added to Cart Successfully";
		
	}

	@Override
	public Cart findUserCart(Long userId) {
		Cart cart = cartRepo.findByUserId(userId);
		
		int totalPrice = 0;
		int totalDiscountedPrice = 0;
		int totalItem = 0;
		
		for(CartItem cartItem : cart.getCartItems()) {
			totalPrice += cartItem.getPrice();
			totalDiscountedPrice += cartItem.getDiscountedPrice();
			totalItem += cartItem.getQuantity();
		}
		
		cart.setTotalDiscountedPrice(totalDiscountedPrice);
		cart.setTotalItem(totalItem);
		cart.setTotalPrice(totalPrice);
		cart.setDiscount(totalPrice - totalDiscountedPrice);
		
		return cartRepo.save(cart);
	}

}
