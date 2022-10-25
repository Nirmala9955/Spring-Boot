package com.sahu.controller;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {
	
	/*@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private ServletConfig servletConfig;
	
	@Autowired
	private HttpSession session;
	*/
	
	@GetMapping(value={"/report"})
	public String generateReport(HttpSession session) {
		System.out.println("DemoController.generateReport()");
		System.out.println("Session id : "+session.getId());
		return "display";
	}
	
}
