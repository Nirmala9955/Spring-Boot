package com.sahu.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sahu.model.UserDetails;
import com.sahu.repository.IUserDetailsRepo;

@Service("userServie")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDetailsRepo userDetailsRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public String registerUser(UserDetails userDetails) {
		userDetails.setPwd(passwordEncoder.encode(userDetails.getPwd()));
		return userDetailsRepo.save(userDetails).getUname()+" details has registered";
	}

	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		//Get Model class object (com.sahu.model.UserDetails)
		Optional<com.sahu.model.UserDetails> opt = userDetailsRepo.findByUname(username);
		if (opt.isEmpty()) 
			throw new IllegalArgumentException("User not found");
		else {
			com.sahu.model.UserDetails details = opt.get();
			/*//convert Set<String> type roles to set<SGA> type roles
			Set<GrantedAuthority> roles = new HashSet<>();
			for (String role : details.getRoles()) {
				SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
				roles.add(authority);
			}
			//Convert model class object(com.sahu.model.UserDetails) to Spring security User object
			User user = new User(details.getUname(), details.getPwd(), roles);*/
			User user = new User(details.getUname(), 
					details.getPwd(), 
					details.getRoles().stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toSet()));
			return user;		
		}	
	}
	
}
