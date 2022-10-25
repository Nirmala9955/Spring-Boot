package com.sahu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sahu.model.Faculty;
import com.sahu.service.ITrainingMgmtService;

@Controller
public class InstituteOperationControler {

	@Autowired
	ITrainingMgmtService mgmtService;
	
	@GetMapping("/")
	public String showHome() {
		return "homePageDef";
	}
	
	@GetMapping("/list_faculties")
	public String showFacultiesPage(Map<String, Object> map) {
		//Use service
		Iterable<Faculty> itList = mgmtService.getAllFaculties();
		//Model attribute
		map.put("facultiesList", itList);
		//return LVN
		return "facultiesPageDef";
	}

	@GetMapping("/list_courses")
	public String showCoursesPage() {
		return "coursesPageDef";
	}
	
	@GetMapping("/list_training")
	public String showTrainingPage() {
		return "trainingPageDef";
	}
	
}
