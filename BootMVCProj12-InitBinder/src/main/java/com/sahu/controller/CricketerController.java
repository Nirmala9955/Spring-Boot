package com.sahu.controller;

import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sahu.model.Cricketer;
import com.sahu.service.ICricketerMgmtService;

@Controller
public class CricketerController {
	
	@Autowired
	private ICricketerMgmtService cricketerMgmtService;
	
	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/register")
	public String showCricketerRegistrationPage(@ModelAttribute("cktr")Cricketer cricketer) {
		return "cricketer_register";
	}

	@PostMapping("/register")
	public String registerCricketer(Map<String, Object> map, @ModelAttribute("cktr")Cricketer cktr, BindingResult errors) {
		//User service
		String message = cricketerMgmtService.registerCricketer(cktr);
		//Keep result in model attribute
		map.put("result", message);
		//return LVN
		return "show_result";
	}
	
	@InitBinder		
	public void myInitBinder(WebDataBinder binder) {
		System.out.println("CricketerController.myInitBinder()");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//Ready Made PropertyEditor to convert String date value to java.util.Date value   
		CustomDateEditor editor = new CustomDateEditor(sdf, false);
		binder.registerCustomEditor(java.util.Date.class, editor);
	}
}
