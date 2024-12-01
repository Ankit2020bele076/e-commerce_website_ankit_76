package com.ecommerce.GunSlinger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.GunSlinger.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
