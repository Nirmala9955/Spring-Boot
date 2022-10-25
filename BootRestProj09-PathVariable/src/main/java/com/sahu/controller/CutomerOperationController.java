package com.sahu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CutomerOperationController {

	@GetMapping("/report/{no}/{name}")
	public String reportData1(@PathVariable(name="name", required = false) String cname, 
							@PathVariable(required = false) Integer no) {
		return "from Report Data1";
	}

	@GetMapping("/report/101/raja")
	public String reportData2(@PathVariable(name="name", required = false) String cname, 
			@PathVariable(required = false) Integer no) {
		return "from Report Data2";
	}

	@GetMapping("/report/101/raja")
	public String reportData3(@PathVariable(name="name", required = false) String cname, 
			@PathVariable(required = false) Integer no) {
		return "from Report Data3";
	}
	
}