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
			auth.ldapAuthentication().contextSource().url("ldap://localhost:10389/o=sahu")
			.managerDn("uid=admin,ou=system").managerPassword("secret") //For connecting LDAP server
			.and().userSearchBase("ou=users").userSearchFilter("(cn={0})") //For authentication
			.groupSearchBase("ou=roles").groupSearchFilter("(uniqueMember={0})")
			.groupRoleAttribute("cn").rolePrefix("ROLE_"); //For authorization
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
