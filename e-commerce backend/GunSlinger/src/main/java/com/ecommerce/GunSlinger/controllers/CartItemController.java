package com.ecommerce.GunSlinger.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.GunSlinger.exception.CartItemException;
import com.ecommerce.GunSlinger.exception.UserException;
import com.ecommerce.GunSlinger.model.CartItem;
import com.ecommerce.GunSlinger.model.User;
import com.ecommerce.GunSlinger.response.ApiResponse;
import com.ecommerce.GunSlinger.service.CartItemService;
import com.ecommerce.GunSlinger.service.UserService;

@RestController
@RequestMapping("/api/cart_item")
public class CartItemController {
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private UserService userService;
	
	@DeleteMapping("/{cartItemId}")
	public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable Long cartItemId, @RequestHeader("Authorization") String jwt) throws UserException, CartItemException{
		
		User user = userService.findUserProfileByJwt(jwt);
		cartItemService.removeCartItem(user.getUserId(), cartItemId);
		
		ApiResponse res = new ApiResponse();
		res.setMessage("Item deleted successfully");
		res.setStatus(true);
		return new ResponseEntity<>(res, HttpStatus.OK);
		
	}
	
	@PutMapping("/{cartItemId}")
	public ResponseEntity<CartItem> updateCartItem(@RequestBody CartItem cartItem, @PathVariable Long cartItemId, @RequestHeader("Authorization") String jwt) throws UserException, CartItemException{
		
		User user = userService.findUserProfileByJwt(jwt);
		
		CartItem updatedCartItem = cartItemService.updateCartItem(user.getUserId(), cartItemId, cartItem);
		
		return new ResponseEntity<>(updatedCartItem, HttpStatus.OK);
		
	}
	
}
