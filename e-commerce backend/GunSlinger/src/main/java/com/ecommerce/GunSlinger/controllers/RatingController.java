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

import com.ecommerce.GunSlinger.exception.ProductException;
import com.ecommerce.GunSlinger.exception.UserException;
import com.ecommerce.GunSlinger.model.Rating;
import com.ecommerce.GunSlinger.model.User;
import com.ecommerce.GunSlinger.request.RatingRequest;
import com.ecommerce.GunSlinger.service.RatingService;
import com.ecommerce.GunSlinger.service.UserService;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/create")
	public ResponseEntity<Rating> createRating(@RequestBody RatingRequest req, @RequestHeader("Authorization") String jwt) throws UserException, ProductException {
		
		User user = userService.findUserProfileByJwt(jwt);
		
		Rating ratings = ratingService.createRating(req, user);
		
		return new ResponseEntity<Rating>(ratings, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/product/{productId}")
	public ResponseEntity<List<Rating>> getProductsRating(@PathVariable Long productId) throws UserException, ProductException{
		
		List<Rating> ratings = ratingService.getProductRating(productId);
		
		return new ResponseEntity<>(ratings, HttpStatus.CREATED);
		
	}
}
