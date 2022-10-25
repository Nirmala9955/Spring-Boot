package com.sahu.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sahu.model.Customer;
import com.sahu.service.ICustomerMgmtService;

@Controller
public class CustomerController {

	@Autowired
	private ICustomerMgmtService customerMgmtService;
	
	@GetMapping("/")
	public String showCustomerFormPage(@ModelAttribute("cust") Customer cust) {
		return "customer_register";
	}
	
	@PostMapping("/register_customer")
	public String registerCustomer(Map<String, Object> map, @ModelAttribute("cust") Customer cust) {
		return "show_result";
	}
	
	@ModelAttribute("countriesInfo")
	public Set<String> populateCountries(){
		return customerMgmtService.getAllCountries();
	}

	@ModelAttribute("languagesInfo")
	public Set<String> populateLanguages(){
		return customerMgmtService.getAllLanguages();
	}
	
	@ModelAttribute("hobbiesInfo")
	public Set<String> populateHobbies(){
		return customerMgmtService.getAllHobbies();
	}
	
	@PostMapping("/states")
	public String showStatesByCountry(@RequestParam("country") String country, @ModelAttribute("cust") Customer cust, Map<String, Object> map) {
		//Use service
		List<String> statesList =customerMgmtService.getStatesByCountry(country);
		//add to model attribute
		map.put("statesInfo", statesList);
		//return LVN
		return "customer_register";
	}
	
}
