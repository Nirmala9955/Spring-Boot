package com.sahu.runners;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sahu.entity.CoronaVaccine;
import com.sahu.service.ICoronaVaccineService;

@Component
public class QueryMethodsJPQLTestRunner implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineService coronaVaccineService;

	@Override
	public void run(String... args) throws Exception {
		/*coronaVaccineService.fetchVaccinesByCompany("Pyzer").forEach(System.out::println);
		
		coronaVaccineService.fetchVaccinesByCompanies("Pyzer", "Russie", "Pyzer").forEach(System.out::println);
		coronaVaccineService.fetchVaccinesByNames("Pyzer", "Pyzer").forEach(vaccine-> System.out.println(vaccine[0]+" "+vaccine[1]+" "+vaccine[2]));
		coronaVaccineService.fetchVaccinesByNames("Pyzer", "Pyzer").forEach(vaccine-> { 
			for (Object val : vaccine)
				System.out.println(val+" ");
			System.out.println();
		});
		coronaVaccineService.fetchVaccineNamesByPriceRange(400.0, 600.0).forEach(System.out::println);
		
		Optional<CoronaVaccine> vaccine = coronaVaccineService.fetchVaccineByName("sputnik");
		if(vaccine.isPresent())
			System.out.println(vaccine.get());
		else
			System.out.println("Record not found");
		
		Object objVaccine = coronaVaccineService.fetchVaccineDataByName("sputnik");
		Object[] vaccineDetails = (Object[]) objVaccine;
		for(Object val : vaccineDetails)
			System.out.println(val+" ");
		System.out.println();
		
		System.out.println(coronaVaccineService.fetchVaccineCountryByName("sputnik"));
		
		System.out.println(coronaVaccineService.fetchVaccinesCount());
		
		Object result[] = (Object[]) coronaVaccineService.fetchVaccineAggregateDetailsByPriceRange(400.0, 600.);
		System.out.println("Vaccines Count : "+result[0]);
		System.out.println("Max Price : "+result[1]);
		System.out.println("Min Price : "+result[2]);
		System.out.println("Sum Price : "+result[3]);
		System.out.println("Avg Price : "+result[4]);*/
		
		int count = coronaVaccineService.ModifiyVaccinePriceByCountry(560.0, "Russia");
		System.out.println("Number of vaccines updated : "+count);
		
		System.out.println("Number of vaccines deleted : "+coronaVaccineService.removeVaccinesByPriceRange(400.0, 600.0));
		
		int isInserted = coronaVaccineService.registerVaccine(858L, "Serim", "India", "Covaxin", 458.0, 2);
		System.out.println(isInserted==0?"Record not inserted":"Record inserted");
		
		System.out.println("System date and time : "+coronaVaccineService.fetchSystemDate());
		
		int tableCreated = coronaVaccineService.createTempTable();
		System.out.println(tableCreated);
		System.out.println(tableCreated==0?"Table has created":"Table has not created");
	}

}
