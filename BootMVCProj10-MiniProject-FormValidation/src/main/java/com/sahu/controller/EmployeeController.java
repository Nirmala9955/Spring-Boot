package com.sahu.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sahu.model.Employee;
import com.sahu.service.IEmployeeMgmtService;
import com.sahu.validator.EmployeeValidator;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeMgmtService employeeMgmtService;
	
	@Autowired
	private EmployeeValidator employeeValidator;
	
	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/emp_report")
	public String showEmployeeReport(@PageableDefault(page = 0, size = 3, sort = "job", direction = Direction.ASC) Pageable pageable, Map<String, Object> map) {
		//User Service
		Page<Employee> page = employeeMgmtService.getEmployeesPageData(pageable);
		//Keep results as model attribute
		map.put("pageData", page);
		//return LVN
		return "employee_report";
	}
	
	@GetMapping("/add_employee")
	public String showAddEmployeeForm(@ModelAttribute("emp") Employee emp) {
		return "add_employee";
	}
	
	@PostMapping("/add_employee")
	public String insertEmployee(HttpSession session, @ModelAttribute("emp") Employee emp, BindingResult bindingResult) {
		if(emp.getVflag().equalsIgnoreCase("no")) {
			if (employeeValidator.supports(emp.getClass())) {
				employeeValidator.validate(emp, bindingResult);
			
				if (bindingResult.hasErrors())
					return "add_employee";
			}
		}	
		
		//Application/ business logic errors
		if (emp.getJob().equalsIgnoreCase("PRESIDENT") || emp.getJob().equalsIgnoreCase("QUEEN")) {
			bindingResult.rejectValue("job", "emp.job.restriction");
			return "add_employee";
		}
		
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
	public String editEmployee(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp, BindingResult bindingResult) {
		if(emp.getVflag().equalsIgnoreCase("no")) {
			if (employeeValidator.supports(emp.getClass())) {
				employeeValidator.validate(emp, bindingResult);
			
				if (bindingResult.hasErrors())
					return "modify_employee";
			}
		}
		
		//Application/ business logic errors
		if (emp.getJob().equalsIgnoreCase("PRESIDENT") || emp.getJob().equalsIgnoreCase("QUEEN")) {
			bindingResult.rejectValue("job", "emp.job.restriction");
			return "modify_employee";
		}
		
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
