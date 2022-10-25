package com.sahu.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("stu")
public final class Student {
	
	@Autowired
	//@Qualifier("java")
	@Qualifier("courseID")
	private ICourseMaterial material;
	
	public void preparation(String examName) {
		System.out.println("Preparation started for "+examName);
		String courseContent = material.courseContent();
		double price = material.price();
		System.out.println("Preparation is going on using\n"+courseContent+"\nwith price "+price);
		System.out.println("Preparation is completed for "+examName);
	}
	
}
