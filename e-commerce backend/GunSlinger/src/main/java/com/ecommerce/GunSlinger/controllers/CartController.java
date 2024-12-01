package com.ecommerce.GunSlinger.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.GunSlinger.exception.ProductException;
import com.ecommerce.GunSlinger.exception.UserException;
import com.ecommerce.GunSlinger.model.Cart;
import com.ecommerce.GunSlinger.model.User;
import com.ecommerce.GunSlinger.request.AddItemRequest;
import com.ecommerce.GunSlinger.response.ApiResponse;
import com.ecommerce.GunSlinger.service.CartService;
import com.ecommerce.GunSlinger.service.UserService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<Cart> findUserCart(@RequestHeader("Authorization") String jwt) throws UserException{
		
		User user = userService.findUserProfileByJwt(jwt);
		Cart cart = cartService.findUserCart(user.getUserId());
		
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
		
	}
	
	@PutMapping("/add")
	public ResponseEntity<ApiResponse> addItemToCart(@RequestBody AddItemRequest req, @RequestHeader("Authorization") String jwt) throws UserException, ProductException{
		
		User user = userService.findUserProfileByJwt(jwt);
		
		cartService.addCartItem(user.getUserId(), req);
		
		ApiResponse res = new ApiResponse();
		res.setMessage("Cart Item added successfully");
		res.setStatus(true);
		
		return new ResponseEntity<>(res,HttpStatus.OK);
		
	}
	
	
	
}
