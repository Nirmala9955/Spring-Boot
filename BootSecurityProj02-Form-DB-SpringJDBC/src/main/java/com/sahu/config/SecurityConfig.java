package com.sahu.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity //Makes the normal @Configuration class to Spring Security configuration class
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery("SELECT UNAME, PWD, STATUS FROM USERS WHERE UNAME=?") //For Authentication
		.authoritiesByUsernameQuery("SELECT UNAME, ROLES FROM USER_ROLES WHERE UNAME=?"); //For Authorization
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		//Provide logic for   Authentication and authorization and etc.
		http.authorizeRequests().antMatchers("/").permitAll() //No authentication and no authorization 
				.antMatchers("/offers").authenticated() //Only authentication
				.antMatchers("/balance").hasAnyAuthority("CUSTOMER", "MANAGER") //authentication + authorization for "CUSTOMER", "MANAGER" role users 
				.antMatchers("/loanApprove").hasAnyAuthority("MANAGER") //authentication + authorization for "MANAGER" role users
				.anyRequest().authenticated() //Remaining all requests URL must be authenticated
				//.and().httpBasic() //Specify authentication mode
				.and().formLogin().and().rememberMe() //enable remember me option
				.and().logout() //enable logout
				.and().exceptionHandling().accessDeniedPage("/denied") //Exception/ error handling
				.and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true).expiredUrl("/timeout");
	}

}
