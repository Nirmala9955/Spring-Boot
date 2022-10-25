package com.sahu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CutomerOperationController {

	@GetMapping("/report")
	public String reportData(@RequestParam("cno") Integer no, 
							@RequestParam(required = false) String cname) {
		return no+" "+cname;
	}
	
}