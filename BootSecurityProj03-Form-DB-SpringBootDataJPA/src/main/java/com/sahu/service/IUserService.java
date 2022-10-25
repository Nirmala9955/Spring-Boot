package com.sahu.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sahu.model.UserDetails;

public interface IUserService extends UserDetailsService {
	public String registerUser(UserDetails userDetails);
}
