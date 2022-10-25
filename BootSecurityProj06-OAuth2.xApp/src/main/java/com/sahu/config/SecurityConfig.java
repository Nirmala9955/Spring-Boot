package com.sahu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {

	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().antMatchers("/", "/login", "/home").permitAll()
		.anyRequest().authenticated()
		.and().formLogin()
		.and().oauth2Login()
		.and().csrf().disable();
	}*/
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().antMatchers("/", "/login").permitAll()
		.anyRequest().authenticated()
		.and().formLogin()
		.and().oauth2Login()
		.and().csrf().disable();
		
		 return http.build();
	}
	
}
