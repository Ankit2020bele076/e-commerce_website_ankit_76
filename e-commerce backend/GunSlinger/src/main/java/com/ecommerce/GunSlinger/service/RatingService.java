package com.ecommerce.GunSlinger.service;

import java.util.List;

import com.ecommerce.GunSlinger.exception.ProductException;
import com.ecommerce.GunSlinger.model.Rating;
import com.ecommerce.GunSlinger.model.User;
import com.ecommerce.GunSlinger.request.RatingRequest;

public interface RatingService {
	
	public Rating createRating(RatingRequest req, User user) throws ProductException;
	
	public List<Rating> getProductRating(Long productId);
	
}
