package com.sahu.report;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("report")
public class ReportGenerator {
	
	//@Scheduled(initialDelay = 2000, fixedDelay = 3000)
	//@Scheduled(fixedDelay = 3000)
	//@Scheduled(fixedDelayString = "3000")
	@Scheduled(initialDelay = 2000, fixedRate = 5000)
	public void generateSalesReport() {
		System.out.println("Task1 - Thread Name : "+Thread.currentThread().getName());
		System.out.println("Task1 - Thread HashCode : "+Thread.currentThread().hashCode());
		System.out.println("Task1 - Sales Report on : "+new Date());
	}

	@Scheduled(initialDelay = 2000, fixedDelay = 3000)
	public void generateSalesReport1() {
		System.out.println("Task2 - Thread Name : "+Thread.currentThread().getName());
		System.out.println("Task2 - Thread HashCode : "+Thread.currentThread().hashCode());
		System.out.println("Task2 - Sales Report on : "+new Date());
	}
	
}
