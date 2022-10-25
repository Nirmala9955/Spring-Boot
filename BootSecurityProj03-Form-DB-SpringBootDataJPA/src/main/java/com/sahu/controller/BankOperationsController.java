package com.sahu.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class BankOperationsController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/offers")
	public String showOffers() {
		return "show_offers";
	}
	
	@PostMapping("/balance")
	public String checkBalance(Map<String, Object> map) {
		map.put("balance", new Random().nextInt(1000000000));
		return "show_balance";
	}
	
	@GetMapping("/loanApprove")
	public String approveLoan(Map<String, Object> map) {
		map.put("amount", new Random().nextInt(1000000000));		
		return "approve_loan";
	}

	@GetMapping("/denied")
	public String accessDenied(Map<String, Object> map) {
		map.put("userName", SecurityContextHolder.getContext().getAuthentication().getName());
		return "access_denied";
	}
	
}
