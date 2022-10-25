package com.sahu;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class BootProj12RunnersClaassApplication {

	@Bean
	@Order(-20)
	public CommandLineRunner createSchedulingRunner() {
		CommandLineRunner commandLineRunner = (String... args) -> {
			System.out.println("Scheduling Runner");
		};
		return commandLineRunner;
	}
	
	@Bean
	@Order(50)
	public ApplicationRunner createTimeRunner() {
		ApplicationRunner commandLineRunner = (ApplicationArguments args) -> {
			System.out.println("Time Runner");
		};
		return commandLineRunner;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(BootProj12RunnersClaassApplication.class, args);
	}

}
