package com.ecommerce.GunSlinger.config;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtProvider {
	SecretKey key = Keys.hmacShaKeyFor(JwtConstants.SECRET_KEY.getBytes());
	
	public String generateToken(Authentication auth) {
		return Jwts.builder().setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime()+846000000)).claim("email", auth.getName()).signWith(key).compact();
	}
	
	public String getEmailFromToken(String jwt) {
		jwt = jwt.substring(7);
		Claims claim = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
		String email = String.valueOf(claim.get("email"));
		return email;
	}
}