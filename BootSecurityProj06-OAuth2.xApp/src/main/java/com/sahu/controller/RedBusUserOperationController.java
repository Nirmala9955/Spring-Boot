package com.sahu.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedBusUserOperationController {

	@GetMapping("/home")
	public String showHome() {
		return "Hello, Welcome to home page RedBus.com";
	}

	@GetMapping("/after")
	public String afterLoginPage() {
		return "Hello, Successfully logged into Redbus.com";
	}

	@GetMapping("/user")
	public Authentication showUserDetails(Principal principal) {
		System.out.println("Logged in details: "+principal.getName());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth;
	}
	
}
