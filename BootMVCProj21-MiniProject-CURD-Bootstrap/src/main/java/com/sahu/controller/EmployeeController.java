package com.sahu.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sahu.model.Employee;
import com.sahu.service.IEmployeeMgmtService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeMgmtService employeeMgmtService;
	
	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/emp_report")
	public String showEmployeeReport(Map<String, Object> map) {
		//User Service
		Iterable<Employee> empsList = employeeMgmtService.getAllEmployees();
		//Keep results as model attribute
		map.put("empsList", empsList);
		//return LVN
		return "employee_report";
	}
	
	@GetMapping("/add_employee")
	public String showAddEmployeeForm(@ModelAttribute("emp") Employee emp) {
		return "add_employee";
	}
	
	@PostMapping("/add_employee")
	public String insertEmployee(HttpSession session, @ModelAttribute("emp") Employee emp) {
		//Use service
		String result = employeeMgmtService.insertEmployee(emp);
		//Add result to HttpSession object
		session.setAttribute("resultMsg", result);
		//return LVN
		return "redirect:emp_report";
	}
	
	@GetMapping("/edit_employee")
	public String showEditEmployeeFormPage(@RequestParam("eno") Integer eno,
							@ModelAttribute("emp") Employee emp) {
		//use service
		Employee employee = employeeMgmtService.getEmployeeByEmpNo(eno);
		BeanUtils.copyProperties(employee, emp);
		//return LVN
		return "modify_employee";
	}
	
	@PostMapping("/edit_employee")
	public String editEmployee(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp) {
		//Use service
		String result = employeeMgmtService.updateEmployee(emp);
		//Add result to RedirectAttributes object
		attrs.addFlashAttribute("resultMsg", result);
		//return LVN
		return "redirect:emp_report";
	}
	
	@GetMapping("/delete_employee")
	public String deleteEmployee(@RequestParam("eno") Integer eno,
								RedirectAttributes attrs) {
		//use service
		String result = employeeMgmtService.deleteEmployeeByEno(eno);
		//Add result to RedirectAttributes object
		attrs.addFlashAttribute("resultMsg", result);
		//return LVN
		return "redirect:emp_report";
	}
	
}
