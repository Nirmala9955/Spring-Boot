package com.sahu.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sahu.model.UserDetails;

public interface IUserDetailsRepo extends PagingAndSortingRepository<UserDetails, Integer> {

	public Optional<UserDetails> findByUname(String uname);
	
}
