package com.sahu.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sahu.model.Employee;

@Controller
public class TestController {

	@GetMapping("/report")
	public String  showReport(Map<String, Object> map) {
		//Add model attributes (Simple values)
		/*map.put("name", "Rajkumar");
		map.put("age", 40);
		map.put("address", "Hyd");
		*/
		/*String nickNames[] = new String[] {"Raja", "Jani", "King", "RK"};
		Set<Long> mobileNoSet = new HashSet<>();
		mobileNoSet.add(99999999999l);
		mobileNoSet.add(88888888888l);
		List<String> courseList = List.of("Java", "Spring", "Spring  Boot", "Microservice");
		Map<String, Long> idsMap = Map.of("Aadhar", 34343223l,
								"Voter Id", 3435333l,
								"Pan No", 553334l);
		//Create model attributes
		map.put("nickNames", nickNames);
		map.put("mobileNoSet", mobileNoSet);
		map.put("courseList", courseList);
		map.put("idsMap", idsMap);*/
		 
		/*List<Employee> empList = List.of(
					new Employee(101, "Rajesh", "Clerk", 90000.0),	
					new Employee(102, "Mahesh", "Developer", 190000.0),
					new Employee(103, "Anil", "TL", 180000.0)
				);
		map.put("empList", empList);*/
		
		
		Employee employee = new Employee(101, "Rajesh", "Clerk", 90000.0);
		map.put("employee", employee);
		//retrun LVN
		return "show_report";
	}
	
}

