package com.sahu.report;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("report")
public class ReportGenerator {

	@Scheduled(cron = "15 * * * * *")
	@Scheduled(cron = "0/20 * * * * *")
	public void generateSalesReport() {
		System.out.println("Sales Report on : "+new Date());
	}

}