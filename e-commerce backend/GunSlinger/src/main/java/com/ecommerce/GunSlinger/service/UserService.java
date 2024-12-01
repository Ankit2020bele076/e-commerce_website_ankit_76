package com.ecommerce.GunSlinger.service;

import com.ecommerce.GunSlinger.exception.UserException;
import com.ecommerce.GunSlinger.model.User;

public interface UserService {
	
	public User findUserById(Long userId) throws UserException;
	
	public User findUserProfileByJwt(String jwt) throws UserException;
	
	
	
}
