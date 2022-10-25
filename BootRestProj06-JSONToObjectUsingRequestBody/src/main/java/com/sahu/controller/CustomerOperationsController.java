package com.sahu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sahu.model.Customer;

@RestController
public class CustomerOperationsController {
	
	@PostMapping("/register")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<String>(customer.toString(), HttpStatus.OK);
	}
	
}
