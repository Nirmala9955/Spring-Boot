package com.sahu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahu.model.Customer;

@RestController
public class CustomerOperationsController {

	@GetMapping("/report")
	public Customer showDate( ) {
		Customer cust =  new Customer(1001, "raja", "hyd", 34353.5f);
		return cust;
	}

}
