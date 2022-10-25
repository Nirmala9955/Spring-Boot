package com.sahu.runners;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.sahu.entity.CoronaVaccine;
import com.sahu.service.ICoronaVaccineService;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineService coronaVaccineService;

	@Override
	public void run(String... args) throws Exception {
		try {
			// Invoke methods
			//CoronaVaccine vaccine = new CoronaVaccine(null, "COVAXIN", "Bharat-Bio-Tech", "India", 795.0, 2);
			//System.out.println(coronaVaccineService.registerVaccine(vaccine));
			
			//Bulk insertion/ batch insertion
			/*		CoronaVaccine vaccine1 = new CoronaVaccine(null, "Sputnlk", "Russie", "Russia", 568.5, 2);
					CoronaVaccine vaccine2 = new CoronaVaccine(null, "Pyzer", "Pyzer", "USA", 568.5, 2);
					CoronaVaccine vaccine3 = new CoronaVaccine(null, "Moderena", "Moderena", "USA", 568.5, 2);
					List<CoronaVaccine> coronaVaccines = new ArrayList<>();
					coronaVaccines.add(vaccine1);
					coronaVaccines.add(vaccine2);
					coronaVaccines.add(vaccine2);*/
			
			/*Iterable<CoronaVaccine> listCoronaVaccines =
					coronaVaccineService.registerBatch(Arrays.asList(new CoronaVaccine(null, "Sputnlk", "Russie", "Russia", 568.5, 2), 
							new CoronaVaccine(null, "Pyzer", "Pyzer", "USA", 568.5, 2),
							 new CoronaVaccine(null, "Moderena", "Moderena", "USA", 568.5, 2)));
			
			System.out.println("The regNos. are - ");
			listCoronaVaccines.forEach(vaccine->System.out.println(vaccine.getRegNo()));*/
			
			//System.out.println("Records Count - "+coronaVaccineService.getVaccineCount());
			
			//System.out.println("8 Reg No vaccine available ? - "+coronaVaccineService.checVaccineAvailabilityByRegNo(8l));
			
			//coronaVaccineService.fetchAllDetails().forEach(System.out::println);
		
			//coronaVaccineService.fetchAllDetailsByIds(Arrays.asList(1l, 2l, 3l, 4l, 5l)).forEach(System.out::println);;
			
			/*Optional<CoronaVaccine> optVaccine = coronaVaccineService.fetchVaccineById(11l);
			if (optVaccine.isPresent()) 
				System.out.println(optVaccine.get());
			optVaccine.orElseThrow(()->new IllegalArgumentException("Record not found"));
			*/
			
			//System.out.println(coronaVaccineService.removeVaccineByRegNo(8l));
			//CoronaVaccine vaccine = new CoronaVaccine();
			//vaccine.setRegNo(12l);
			//System.out.println(coronaVaccineService.removeVaccineByObject(vaccine));
			
			//System.out.println(coronaVaccineService.removeVaccineByIds(Arrays.asList(21l, 31l, 41l, 6l)));
			System.out.println(coronaVaccineService.removeAllVaccines());
			
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
