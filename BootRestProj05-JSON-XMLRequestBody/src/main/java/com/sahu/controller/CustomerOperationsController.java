package com.sahu.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sahu.model.Customer;

@RestController
public class CustomerOperationsController {

	@PostMapping("/register")
	public String registerCustomer(@RequestBody Customer customer) {
		return customer.toString();
	}
	
}
