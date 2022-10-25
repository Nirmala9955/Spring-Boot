package com.sahu.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sahu.editor.LocalDateEditor;
import com.sahu.editor.LocalDateTimeEditor;
import com.sahu.editor.LocalTimeEditor;
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
		if (errors.hasErrors())
			return "cricketer_register";
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
		binder.registerCustomEditor(LocalDate.class, new LocalDateEditor());
		binder.registerCustomEditor(LocalTime.class, new LocalTimeEditor());
		binder.registerCustomEditor(LocalDateTime.class, new LocalDateTimeEditor());
	}
	
}
