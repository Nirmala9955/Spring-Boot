package com.sahu.runners;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.sahu.entity.CoronaVaccine;
import com.sahu.service.ICoronaVaccineService;

@Component
public class JpaRepoTestRunner implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineService coronaVaccineService;

	@Override
	public void run(String... args) throws Exception {	
		try {
			//CoronaVaccine vaccine = new CoronaVaccine(null, "Sputnik", "Russie", "Russia", 567.8, 2);
			//coronaVaccineService.searchVaccinesByGivenData(vaccine, true, "price").forEach(System.out::println);
			/*CoronaVaccine vaccine = coronaVaccineService.getVaccineByRegNo(2l);
			if (vaccine!=null) 
				System.out.println("Vaccine Details - "+vaccine);
			else
				System.out.println("Record not found");	*/
			
			System.out.println(coronaVaccineService.removeVaccineByRegNos(Arrays.asList(5l, 6l, 8l)));
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
	}

}
