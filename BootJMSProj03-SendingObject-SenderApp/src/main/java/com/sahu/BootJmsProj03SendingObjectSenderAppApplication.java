package com.sahu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootJmsProj03SendingObjectSenderAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootJmsProj03SendingObjectSenderAppApplication.class, args);
	}

}
