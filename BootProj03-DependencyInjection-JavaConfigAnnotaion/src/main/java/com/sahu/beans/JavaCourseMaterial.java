package com.sahu.beans;

import javax.inject.Named;

@Named("java")
public final class JavaCourseMaterial implements ICourseMaterial {

	public JavaCourseMaterial() {
		System.out.println("JavaCourseMaterial.JavaCourseMaterial()");
	}
	
	@Override
	public String courseContent() {
		return "1.OOPS\n2.Exception Handling\n3.Collection";
	}

	@Override
	public double price() {
		return 400;
	}
	
}
