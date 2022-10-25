package com.sahu.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sahu.service.IVaccineMgmtService;

@Component
public class StoreProcedureRunner implements CommandLineRunner {

	@Autowired
	private IVaccineMgmtService vaccineMgmtService;
	
	@Override
	public void run(String... args) throws Exception {
		//vaccineMgmtService.searchVaccineByPriceRange(400.0, 900.0).forEach(System.out::println);
		
		//System.out.println(vaccineMgmtService.authenticate("Raja", "Rani"));
		
		Object result[] = vaccineMgmtService.getEmpDetailsByEno(7499);
		System.out.println("EMP Name : "+result[1]);
		System.out.println("EMP Job : "+result[2]);
		System.out.println("EMP Name : "+result[3]);
		System.out.println("EMP Dept No : "+result[0]);
	}

}
