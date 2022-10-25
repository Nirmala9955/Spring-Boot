package com.sahu.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahu.model.Company;
import com.sahu.model.Customer;

@RestController
public class CustomerOperationsController {
	
	/*@GetMapping("/report")
	public ResponseEntity<Customer> showData() {
		Customer cust = new Customer(1001, "raja", 56744.67f);
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}
	*/
	
	@GetMapping("/report")
	public ResponseEntity<Customer> showData() {
		Customer cust = new Customer(1001, "raja", 56744.67f,
						new String[] {"blue", "red", "yellow"},
						List.of("10th", "10+2", "BCA"),
						Set.of(56445353433l, 354534343343l, 3434355333l),
						Map.of("aadhar",5454252333l, "panNo", 5452454262l),
						new Company("SAMSUNG","hyd", "Electronics", 4000));
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}
			
}