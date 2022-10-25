package com.sahu.beans;

import javax.annotation.Resource;
import javax.inject.Named;

@Named("stu")
public final class Student {

	//@Inject
	@Resource(name = "courseID")  
	//@Named("courseID")
	private ICourseMaterial material;

	public void preparation(String examName) {
		System.out.println("Preparation started for " + examName);
		String courseContent = material.courseContent();
		double price = material.price();
		System.out.println("Preparation is going on using\n" + courseContent + "\nwith price " + price);
		System.out.println("Preparation is completed for " + examName);
	}

}
