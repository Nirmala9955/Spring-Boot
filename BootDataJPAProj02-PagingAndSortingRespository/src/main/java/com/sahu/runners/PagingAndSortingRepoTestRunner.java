package com.sahu.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.sahu.service.ICoronaVaccineService;

@Component
public class PagingAndSortingRepoTestRunner implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineService coronaVaccineService;

	@Override
	public void run(String... args) throws Exception {	
		try {
			/*Iterable<CoronaVaccine> listEntities = coronaVaccineService.fetchDetails(true, "price");
			listEntities.forEach(System.out::println);*/
			
			//coronaVaccineService.fetchDetailsByPageNo(2, 4, true, "price").forEach(System.out::println);
			coronaVaccineService.fetchDetailsByPagination(2);
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
