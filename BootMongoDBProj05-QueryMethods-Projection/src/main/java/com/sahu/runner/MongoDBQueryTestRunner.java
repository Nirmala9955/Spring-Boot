package com.sahu.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sahu.service.ICustomerMgmtService;

@Component
public class MongoDBQueryTestRunner implements CommandLineRunner {
	
	@Autowired
	private ICustomerMgmtService customerMgmtService;
	
	@Override
	public void run(String... args) throws Exception {
		//invoke method
		/*customerMgmtService.fetchCustomersDataByAddress("Hyd").forEach(doc -> {
			for (Object attr : doc) {
				System.out.print(attr+" ");
			}
			System.out.println();
		});
		
		customerMgmtService.fetchCustomersByAddress("Hyd").forEach(System.out::println);
		
		customerMgmtService.fetchCustomersByAddressAndName("Hyd", "Ramesh").forEach(doc -> {
			for (Object attr : doc) {
				System.out.print(attr+" ");
			}
			System.out.println();
		});
		
		customerMgmtService.fetchCustomersByAddressOrName("Hyd", "Rajesh").forEach(doc -> {
			for (Object attr : doc) {
				System.out.print(attr+" ");
			}
			System.out.println();
		});
		
		customerMgmtService.fetchCustomersByBillAmountRange(10000.0, 50000.0).forEach(doc -> {
			for (Object attr : doc) {
				System.out.print(attr+" ");
			}
			System.out.println();
		});*/
		
		/*customerMgmtService.fetchCustomersByRegAddress("^H").forEach(System.out::println);
		customerMgmtService.fetchCustomersByRegAddress("g$").forEach(System.out::println);
		customerMgmtService.fetchCustomersByRegAddress("y").forEach(System.out::println);*/
		
		System.out.println("Count of docs having bill amount range 10000 to 50000 : "+customerMgmtService.fetchCustomersCountByBillAmountRange(10000.0, 50000.0));
		
		customerMgmtService.fetchCustomersByBillAmountSorted().forEach(System.out::println);
		
		System.out.println("No. of document deleted : "+customerMgmtService.removeCustomersWithNoBillAmount());
		
		System.out.println("Is customers exit with bill amount range 10000 to 50000 : "+customerMgmtService.checkCustomersExistWithBillAmountRang(10000.0, 50000.0));
	}

}
