package com.sahu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataBindingController {
	
	/*@GetMapping("/data")
	public String bindData(Map<String, Object> map,
					@RequestParam("sno") Integer no, 
					@RequestParam("sname") String name) {
		System.out.println(no+" "+name);
		//return LVN
		return "show_data";
	}*/
	
	/*@GetMapping("/data")
	public String bindData(Map<String, Object> map,
					@RequestParam Integer no, 
					@RequestParam(required = false) String name) {
		System.out.println(no+" "+name);
		//return LVN
		return "show_data";
	}*/
	
	/*@GetMapping("/data")
	public String bindData(Map<String, Object> map,
					@RequestParam(defaultValue = "1001") Integer sno, 
					@RequestParam(defaultValue = "raja") String sname) {
		System.out.println(sno+" "+sname);
		//return LVN
		return "show_data";
	}*/
	
	@GetMapping("/data")
	public String bindData(Map<String, Object> map,
			@RequestParam Integer sno, 
			@RequestParam String[] sname, @RequestParam("sname") List<String> names) {
		System.out.println(sno+" "+sname);
		//return LVN
		return "show_data";
	}
	
}
