package com.ecommerce.GunSlinger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.GunSlinger.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	@Query("Select o from Order o Where o.user.userId=:userId And (o.orderStatus='PLACED' OR o.orderStatus='CONFIRMED' OR o.orderStatus='SHIPPED' OR o.orderStatus='DELIVERED')")
	public List<Order> getUsersOrders(@Param("userId") Long userId);
	
}
