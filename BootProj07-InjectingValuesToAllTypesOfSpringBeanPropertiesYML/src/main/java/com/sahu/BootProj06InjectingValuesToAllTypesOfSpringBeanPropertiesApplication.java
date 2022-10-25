package com.sahu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.sahu.model.Employee;

@SpringBootApplication
public class BootProj06InjectingValuesToAllTypesOfSpringBeanPropertiesApplication {

	public static void main(String[] args) {
		//Get IoC container
		ApplicationContext ctx = SpringApplication.run(BootProj06InjectingValuesToAllTypesOfSpringBeanPropertiesApplication.class, args);
		//Get Spring bean class object
		Employee emp = ctx.getBean("employee", Employee.class);
		System.out.println(emp);
		//close IoC container
		((ConfigurableApplicationContext) ctx).close();
	}

}
