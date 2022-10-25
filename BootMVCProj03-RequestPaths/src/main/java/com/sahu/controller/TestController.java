package com.sahu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	@RequestMapping("/")
	public String showHome() {
		return "home";
	}
	
	/*//@RequestMapping(value = "/report", method = RequestMethod.GET)
	//@GetMapping(value={"/report", "/report1", "/report2"})
	@GetMapping("/report")
	public String showReport() {
		System.out.println("TestController.showReport()");
		return "display";
	}
	
	//@RequestMapping(value= "/report", method = RequestMethod.POST)
	//@PostMapping("/report")
	@GetMapping("/report")
	public String showReport1() {
		System.out.println("TestController.showReport1()");
		return "display1";
	}*/
	
	@GetMapping(value={"/report"})
	public String showReport() {
		System.out.println("TestController.showReport()");
		return "display";
	}
	
}
