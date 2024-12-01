package com.ecommerce.GunSlinger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.GunSlinger.model.Cart;
import com.ecommerce.GunSlinger.model.CartItem;
import com.ecommerce.GunSlinger.model.Product;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	
	@Query("Select ci from CartItem ci Where ci.cart=:cart And ci.product=:product And ci.size=:size And ci.userId=:userId")
	public CartItem isCartItemExist(@Param("cart") Cart cart, @Param("product") Product product, @Param("size") String size, @Param("userId") Long userId);
	
}
