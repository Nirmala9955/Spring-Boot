package com.sahu.runner;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sahu.document.DrivingLicense;
import com.sahu.document.Person;
import com.sahu.service.IRTOMgmtService;

@Component
public class AssociationTestRunner implements CommandLineRunner {

	@Autowired
	private  IRTOMgmtService  irtoMgmtService;
	
	@Override
	public void run(String... args) throws Exception {
		//Prepare Person Object
		Person person = new Person();
		person.setPId(new Random().nextInt(1000000));
		person.setPName("Ritesh");
		person.setPAddress("Hyd");
		//Prepare Child Object
		DrivingLicense license = new DrivingLicense();
		license.setLId(Long.valueOf(new Random().nextInt(5000000)));
		license.setType("Two-wheeler");
		license.setExpiryDate(LocalDate.of(2025, 12, 30));
		//Map objects
		person.setLicense(license);
		//Invoke method
		//System.out.println(irtoMgmtService.savePersonWithLicense(person));
		
		//Prepare Person Object
		Person person1 = new Person();
		person1.setPId(new Random().nextInt(1000000));
		person1.setPName("Hitesh");
		person1.setPAddress("Vizg");
		//Prepare Child Object
		DrivingLicense license1 = new DrivingLicense();
		license1.setLId(Long.valueOf(new Random().nextInt(5000000)));
		license1.setType("Two-wheeler");
		license1.setExpiryDate(LocalDate.of(2025, 12, 30));
		//Map objects
		license1.setPerson(person1);
		//Invoke method
		//System.out.println(irtoMgmtService.saveLicenseWithPerson(license1));
		
		irtoMgmtService.fetchAllPersons().forEach(per ->{
			System.out.println("Parent : "+per);
			System.out.println("Child : "+per.getLicense());
		});
		
		irtoMgmtService.fetchAllDrivingLicenses().forEach(dl ->{
			System.out.println("Child : "+dl);
			System.out.println("Parent : "+dl.getPerson());
		});
	}

}
