package com.sahu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.sahu.beans.Student;

@SpringBootApplication
@ImportResource("com/sahu/cfg/applicationContext.xml")
public class BootProj02DependencyInjectionApplication {

	public static void main(String[] args) {
		//Get IoC container
		ApplicationContext context = SpringApplication.run(BootProj02DependencyInjectionApplication.class, args);
		//Get target Spring bean
		Student student = context.getBean("stu", Student.class);
		//invoke business method
		student.preparation("CTS-interview");
		//close container
		((ConfigurableApplicationContext) context).close();
	}

}
