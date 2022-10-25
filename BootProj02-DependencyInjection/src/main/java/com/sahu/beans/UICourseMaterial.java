package com.sahu.beans;

import org.springframework.stereotype.Component;

@Component("ui")
public final class UICourseMaterial implements ICourseMaterial {

	public UICourseMaterial() {
		System.out.println("UICourseMaterial.UICourseMaterial()");
	}
	
	@Override
	public String courseContent() {
		return "1.HTML\n2.CSS\n3.JavaScript";
	}

	@Override
	public double price() {
		return 200;
	}
	
}
