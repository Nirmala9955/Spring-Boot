package com.sahu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sahu.model.Employee;
import com.sahu.service.IEmployeeMgmtService;

@Controller
public class EmployeeReportController {

	@Autowired
	private IEmployeeMgmtService employeeMgmtService;
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/report")
	public String generateReprot(@RequestParam("type") String type, Map<String, Object> map) {
		//use service
		Iterable<Employee> iterableEmp = employeeMgmtService.getAllEmployees();
		//Add to model attribute
		map.put("empList", iterableEmp);
		//return LVN
		if (type.equalsIgnoreCase("pdf"))
			return "pdf_report";
		else
			return "excel_report";
	}
	
}
