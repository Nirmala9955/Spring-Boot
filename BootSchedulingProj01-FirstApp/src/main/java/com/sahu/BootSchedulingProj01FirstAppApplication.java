package com.sahu;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootSchedulingProj01FirstAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootSchedulingProj01FirstAppApplication.class, args);
		System.out.println("Thread Name - "+Thread.currentThread().getName());
		System.out.println("Application started at : "+new  Date());
	}

}
