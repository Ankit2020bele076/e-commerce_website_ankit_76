package com.ecommerce.GunSlinger.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.GunSlinger.config.JwtProvider;
import com.ecommerce.GunSlinger.exception.UserException;
import com.ecommerce.GunSlinger.model.User;
import com.ecommerce.GunSlinger.repository.UserRepository;
import com.ecommerce.GunSlinger.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Override
	public User findUserById(Long userId) throws UserException {
		
		Optional<User> user = userRepo.findById(userId);
		
		if(user.isPresent()) {
			return user.get();
		}
		
		throw new UserException("User not found with id- "+userId);
	}

	@Override
	public User findUserProfileByJwt(String jwt) throws UserException {
		String email = jwtProvider.getEmailFromToken(jwt);
		
		User user = userRepo.findByEmail(email);
		
		if(user == null) {
			throw new UserException("User not found with email- "+email);
		}
		return user;
		
	}

}
