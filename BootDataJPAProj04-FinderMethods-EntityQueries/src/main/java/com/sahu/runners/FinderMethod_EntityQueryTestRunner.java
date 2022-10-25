package com.sahu.runners;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sahu.entity.CoronaVaccine;
import com.sahu.service.ICoronaVaccineService;

@Component
public class FinderMethod_EntityQueryTestRunner implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineService coronaVaccineService;

	@Override
	public void run(String... args) throws Exception {	
		coronaVaccineService.fetchVaccinesByCompany("Bharat-Bio-Tech").forEach(System.out::println);

		coronaVaccineService.fetchVaccinesByPriceLessThan(400.5).forEach(System.out::println);
		coronaVaccineService.fetchVaccinesByPriceBetween(400.5, 500.0).forEach(System.out::println);
		coronaVaccineService.fetchVaccinesByNameLike("P%").forEach(System.out::println);
		coronaVaccineService.fetchVaccinesByNameLike("____").forEach(System.out::println);
		coronaVaccineService.fetchVaccinesByNameStartingWith("P").forEach(System.out::println);
		coronaVaccineService.fetchVaccinesByNameEndingWith("na").forEach(System.out::println);
		coronaVaccineService.fetchVaccinesByNameContaining("e").forEach(System.out::println);
		coronaVaccineService.fetchVaccinesByCountryIn("India", "USA").forEach(System.out::println);
		coronaVaccineService.fetchVaccinesByCountryNotIn(Arrays.asList("India", "USA")).forEach(System.out::println);
		coronaVaccineService.searchVaccinesByPriceAscOrder(400.0).forEach(System.out::println);
		coronaVaccineService.searchVaccinesNotFromCountry("USA").forEach(System.out::println);
		
		Optional<CoronaVaccine> optional = coronaVaccineService.getVaccineByRegNo(2l);
		if (optional.isPresent())
			System.out.println(optional.get());
		else
			System.out.println("Record is not found");
		
		//---------------------------------
		coronaVaccineService.searchVaccinesByNameAndCountry("Bharat-Bio-Tech", "India").forEach(System.out::println);
		coronaVaccineService.searchVaccinesByNameInitCharOrPriceRang("P%", 400.0, 500.0).forEach(System.out::println);
		coronaVaccineService.searchVaccinesByCountriesAndPriceRang(Arrays.asList("India", "USA", "UK"), 400.0, 500.0).forEach(System.out::println);		
		coronaVaccineService.searchVaccinesByCountriesAndNamesOrByPrice(Arrays.asList("India", "USA", "UK"), Arrays.asList("Covaxin", "Sputnik"), 500.0).forEach(System.out::println);		
	}

}
