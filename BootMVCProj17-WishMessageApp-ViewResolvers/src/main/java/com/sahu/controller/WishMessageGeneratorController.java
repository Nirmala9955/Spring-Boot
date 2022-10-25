package com.sahu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sahu.service.IWishMessageService;

@Controller
public class WishMessageGeneratorController {

	@Autowired
	private IWishMessageService messageService;

	@RequestMapping("/")
	public String showHome() {
		return "home";
	}
	
	@RequestMapping("/wish")
	public String showWishMessage(Map<String, Object> map) {
		// Use service
		String wishMessage = messageService.generateWishMessage();
		map.put("wishMsg", wishMessage);
		// return LVN
		return "display";
	}

}
