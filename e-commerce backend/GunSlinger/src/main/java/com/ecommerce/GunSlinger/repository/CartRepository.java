package com.ecommerce.GunSlinger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.GunSlinger.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	
	@Query("Select c from Cart c Where c.user.userId=:userId")
	public Cart findByUserId(@Param("userId") Long userId);
	
}
