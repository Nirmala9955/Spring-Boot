package com.sahu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankOperationsController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/offers")
	public String showOffers() {
		return "show_offers";
	}
	
	@GetMapping("/balance")
	public String checkBalance() {
		return "show_balance";
	}
	
	@GetMapping("/loanApprove")
	public String approveLoan() {
		return "approve_loan";
	}

	@GetMapping("/denied")
	public String accessDenied() {
		return "access_denied";
	}

	@GetMapping("/timeout")
	public String sessionExpired() {
		return "session_timeout";
	}
	
}
