package com.ecommerce.GunSlinger.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.GunSlinger.exception.ProductException;
import com.ecommerce.GunSlinger.model.Product;
import com.ecommerce.GunSlinger.model.Review;
import com.ecommerce.GunSlinger.model.User;
import com.ecommerce.GunSlinger.repository.ReviewRepository;
import com.ecommerce.GunSlinger.request.ReviewRequest;
import com.ecommerce.GunSlinger.service.ProductService;
import com.ecommerce.GunSlinger.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepo;
	
	@Autowired
	private ProductService productService;
	
	@Override
	public Review createReview(ReviewRequest req, User user) throws ProductException {
		Product product = productService.findProductById(req.getProductId());
		
		Review review = new Review();
		review.setUser(user);
		review.setProduct(product);
		review.setReview(req.getReview());
		review.setCreatedAt(LocalDateTime.now());
		
		return reviewRepo.save(review);
	}

	@Override
	public List<Review> getAllReview(Long productId) {
		
		return reviewRepo.getAllProductReviews(productId);
		
	}

}
