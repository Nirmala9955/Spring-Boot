package com.sahu.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sahu.service.ICoronaVaccineService;

@Component
public class FinderMethodsStaticProjectionTestRunner implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineService coronaVaccineService;

	@Override
	public void run(String... args) throws Exception {
		coronaVaccineService.searchVaccinesByPrice(400.0).forEach(vaccine -> {
			System.out.println(vaccine.getName() + " " + vaccine.getCountry());
		});

	}

}
