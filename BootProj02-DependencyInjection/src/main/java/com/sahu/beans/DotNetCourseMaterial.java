package com.sahu.beans;

import org.springframework.stereotype.Component;

@Component("dotNet")
public final class DotNetCourseMaterial implements ICourseMaterial {

	public DotNetCourseMaterial() {
		System.out.println("DotNetCourseMaterial.DotNetCourseMaterial()");
	}
	
	@Override
	public String courseContent() {
		return "1.C# OOPS\n2.C# Exception Handling\n3.C# Collection";
	}

	@Override
	public double price() {
		return 300;
	}
	
}
