package com.sahu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sahu.model.UserDetails;
import com.sahu.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;

	@GetMapping("/register")
	public String showUserRegisterForm(@ModelAttribute("userInfo") UserDetails details) {
		return "user_register";
	}
	
	@PostMapping("/register")
	public String registerUserDetails(Map<String, Object> map, @ModelAttribute("userInfo") UserDetails details) {
		//Use service
		String resultMsg = userService.registerUser(details);
		map.put("result", resultMsg);
		return "user_registed_success";
	}
	
	@GetMapping("/showLogin")
	public String showLoginPage() {
		return "custom_login";
	}
	
	
}
