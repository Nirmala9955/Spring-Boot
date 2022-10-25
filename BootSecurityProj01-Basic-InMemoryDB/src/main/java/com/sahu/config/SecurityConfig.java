package com.sahu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ch.qos.logback.core.pattern.color.BoldCyanCompositeConverter;

@Configuration
@EnableWebSecurity //Makes the normal @Configuration class to Spring Security configuration class
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			//Provide logic for configuration Authentication info provider like InMemoryDB, DB s/w etc.
			/*auth.inMemoryAuthentication().withUser("raja").password("{noop}rani").authorities("CUSTOMER");
			auth.inMemoryAuthentication().withUser("ramesh").password("{noop}ramesh123").authorities("MANAGER");*/	
		
			/*auth.inMemoryAuthentication().withUser("raja").password("{noop}rani").roles("CUSTOMER");
			auth.inMemoryAuthentication().withUser("ramesh").password("{noop}ramesh123").roles("MANAGER");*/	

			auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("raja").password("$2a$10$gocQj0TlqPMp6kqPzNIkguTh5zJg9HY9NA2ZihCKJ0H6GZW.MmWFa").roles("CUSTOMER");
			auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("ramesh").password("$2a$10$R.tCZrQSzee50STxfR2b.OYirfDxhwDgh7jEd7uNgLzfINkcGkir2").roles("MANAGER");
		}
		
		@Override
		public void configure(HttpSecurity http) throws Exception {
			//Provide logic for   Authentication and authorization and etc.
			http.authorizeRequests().antMatchers("/").permitAll() //No authentication and no authorization 
					.antMatchers("/offers").authenticated() //Only authentication
					.antMatchers("/balance").hasAnyRole("CUSTOMER", "MANAGER") //authentication + authorization for "CUSTOMER", "MANAGER" role users 
					.antMatchers("/loanApprove").hasRole("MANAGER") //authentication + authorization for "MANAGER" role users
					.anyRequest().authenticated() //Remaining all requests URL must be authenticated
					//.and().httpBasic() //Specify authentication mode
					.and().formLogin()
					.and().rememberMe() //enable remember me option
					.and().logout() //enable logout
					.and().exceptionHandling().accessDeniedPage("/denied") //Exception/ error handling
					.and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true).expiredUrl("/timeout");
		}

}
