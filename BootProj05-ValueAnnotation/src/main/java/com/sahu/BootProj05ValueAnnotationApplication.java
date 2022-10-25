package com.sahu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.sahu.beans.BillGenerator;

@SpringBootApplication
public class BootProj05ValueAnnotationApplication {

	public static void main(String[] args) {
		//Get IoC container
		ApplicationContext ctx=  SpringApplication.run(BootProj05ValueAnnotationApplication.class, args);
		//Get target Spring bean class
		BillGenerator bill = ctx.getBean("bill", BillGenerator.class);
		System.out.println(bill);
		//Close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
