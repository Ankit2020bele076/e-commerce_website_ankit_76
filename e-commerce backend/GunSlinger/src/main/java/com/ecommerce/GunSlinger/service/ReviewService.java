package com.ecommerce.GunSlinger.service;

import java.util.List;

import com.ecommerce.GunSlinger.exception.ProductException;
import com.ecommerce.GunSlinger.model.Review;
import com.ecommerce.GunSlinger.model.User;
import com.ecommerce.GunSlinger.request.ReviewRequest;

public interface ReviewService {
	
	public Review createReview(ReviewRequest req, User user) throws ProductException;
	
	public List<Review> getAllReview(Long productId);
	
}
