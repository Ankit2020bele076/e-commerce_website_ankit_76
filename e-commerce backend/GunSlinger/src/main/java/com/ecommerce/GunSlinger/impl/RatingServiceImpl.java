package com.ecommerce.GunSlinger.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.GunSlinger.exception.ProductException;
import com.ecommerce.GunSlinger.model.Product;
import com.ecommerce.GunSlinger.model.Rating;
import com.ecommerce.GunSlinger.model.User;
import com.ecommerce.GunSlinger.repository.RatingRepository;
import com.ecommerce.GunSlinger.request.RatingRequest;
import com.ecommerce.GunSlinger.service.ProductService;
import com.ecommerce.GunSlinger.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepository ratingRepo;
	
	@Autowired
	private ProductService productService;
	
	@Override
	public Rating createRating(RatingRequest req, User user) throws ProductException {
		Product product = productService.findProductById(req.getProductId());
		
		Rating rating = new Rating();
		rating.setProduct(product);
		rating.setUser(user);
		rating.setRating(req.getRating());
		rating.setCreatedAt(LocalDateTime.now());
		
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getProductRating(Long productId) {
		return ratingRepo.getAllProductRatings(productId);
	}

}
