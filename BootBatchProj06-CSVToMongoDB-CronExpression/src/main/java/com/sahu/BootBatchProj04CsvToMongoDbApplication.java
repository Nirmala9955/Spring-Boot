package com.sahu;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootBatchProj04CsvToMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootBatchProj04CsvToMongoDbApplication.class, args);
		Date date = new Date(3535353);
		LocalDate ld = date.toLocalDate();
	}

}
