package com.sahu;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootSchedulingProj02CronExpressionApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootSchedulingProj02CronExpressionApplication.class, args);
		System.out.println("Thread Name - "+Thread.currentThread().getName());
		System.out.println("Application started at : "+new  Date());
	}

}
