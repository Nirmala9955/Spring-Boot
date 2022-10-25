package com.sahu.runners;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sahu.model.prod.Product;
import com.sahu.model.promotions.Offers;
import com.sahu.repo.prod.IProductRepo;
import com.sahu.repo.promotions.IOffersRepo;

@Component
public class MultiDataSourceRunner implements CommandLineRunner {

	@Autowired
	private IProductRepo productRepo;
	
	@Autowired
	private IOffersRepo offersRepo;
	
	@Override
	public void run(String... args) throws Exception {
		//save objects
		productRepo.saveAll(Arrays.asList(new Product("Table", 100.0, 6000.0),
										new Product("Chair", 10.0, 7000.0),
										new Product("Sofa", 11.0, 62000.0)));
		System.out.println("Products has saved");
		offersRepo.saveAll(Arrays.asList(new Offers("By 1 Get 1", "B1G1", 100.0, LocalDate.of(2022, 10, 11)),
										new Offers("By 1 Get 2", "B1G2", 200.0, LocalDate.of(2022, 10, 11)),
										new Offers("By 2 Get 2", "B2G2", 100.0, LocalDate.of(2022, 10, 11))));
		System.out.println("Offers has saved");
		System.out.println("\n------------- Display Records ---------------");
		productRepo.findAll().forEach(System.out::println);
		offersRepo.findAll().forEach(System.out::println);
	}

}
