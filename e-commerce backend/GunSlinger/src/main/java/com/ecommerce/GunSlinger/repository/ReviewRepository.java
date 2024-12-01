package com.ecommerce.GunSlinger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.GunSlinger.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
	
	@Query("Select r from Review r Where r.product.productId=:productId")
	public List<Review> getAllProductReviews(@Param("productId") Long productId);
	
}
