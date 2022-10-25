package com.sahu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.sahu.beans.CompanyDetails;
import com.sahu.beans.CompanyDetails1;

@SpringBootApplication
public class BootProj06 {

	public static void main(String[] args) {
		//Get IoC container
		ApplicationContext ctx=  SpringApplication.run(BootProj06.class, args);
		//Get target Spring bean class
		CompanyDetails company = ctx.getBean("company", CompanyDetails.class);
		System.out.println(company);
		System.out.println("-----------");
		CompanyDetails1 company1 = ctx.getBean("company1", CompanyDetails1.class);
		System.out.println(company1);
		//Close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
