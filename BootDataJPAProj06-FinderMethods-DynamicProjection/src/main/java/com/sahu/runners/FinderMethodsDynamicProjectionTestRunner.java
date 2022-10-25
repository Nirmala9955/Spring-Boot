package com.sahu.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sahu.service.ICoronaVaccineService;
import com.sahu.type.ResultView1;
import com.sahu.type.ResultView2;
import com.sahu.type.ResultView3;

@Component
public class FinderMethodsDynamicProjectionTestRunner implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineService coronaVaccineService;

	@Override
	public void run(String... args) throws Exception {
		coronaVaccineService.searchVaccinesByCompany("Pyzer", ResultView1.class)
				.forEach(vaccine -> System.out.println(vaccine.getName() + " " + vaccine.getCountry()));
		System.out.println("-----------------------");
		coronaVaccineService.searchVaccinesByCompany("Russie", ResultView2.class)
				.forEach(vaccine -> System.out.println(vaccine.getRegNo() + " " + vaccine.getPrice()));
		System.out.println("-----------------------");
		coronaVaccineService.searchVaccinesByCompany("Russie", ResultView3.class)
				.forEach(vaccine -> System.out.println(vaccine.getName() + " " + vaccine.getCountry()+" "+vaccine.getPrice()));		
	}

}
