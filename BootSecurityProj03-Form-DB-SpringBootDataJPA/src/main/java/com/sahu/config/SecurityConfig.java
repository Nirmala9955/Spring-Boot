package com.sahu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity //Makes the normal @Configuration class to Spring Security configuration class
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(encoder);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		//Provide logic for   Authentication and authorization and etc.
		http.authorizeRequests().antMatchers("/bank/").permitAll() //No authentication and no authorization 
				.antMatchers("/user/register/", "/user/showLogin").permitAll()
				.antMatchers("/bank/offers").authenticated() //Only authentication
				.antMatchers("/bank/balance").hasAnyAuthority("CUSTOMER", "MANAGER") //authentication + authorization for "CUSTOMER", "MANAGER" role users 
				.antMatchers("/bank/loanApprove").hasAnyAuthority("MANAGER") //authentication + authorization for "MANAGER" role users
				.anyRequest().authenticated() //Remaining all requests URL must be authenticated
				//.and().httpBasic() //Specify authentication mode
				.and().formLogin().defaultSuccessUrl("/bank/", true)
				.loginPage("/user/showLogin") //For Get mode request to launch form page
				.loginProcessingUrl("/login") //for POST mode request  to submit and process the request
				.failureUrl("/user/showLogin?error") //Authentication failedURL
				.and().rememberMe() //enable remember me option
				.and().logout() //enable logout
				.logoutSuccessUrl("/user/showLogin?logout") //After logout URL
				.and().exceptionHandling().accessDeniedPage("/bank/denied") //Exception/ error handling
				.and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
				//Disable or enable CSRF protection
				//http.csrf().disable();
	}

}
