package com.ecommerce.GunSlinger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.GunSlinger.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
	
	@Query("Select r from Rating r Where r.product.productId=:productId")
	public List<Rating> getAllProductRatings(@Param("productId") Long productId);
	
}
