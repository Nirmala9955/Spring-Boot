package com.sahu.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sahu.model.Employee;

@Controller
public class EmployeeController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/emp_register")
	public String showForm() {
		return "register";
	}
	
	@PostMapping("/emp_register")
	public String registerEmployee(Map<String, Object> map, @ModelAttribute("emp") Employee emp) {
		//Read and use form data from model class object or send to service class
		return "result";
	}

}
