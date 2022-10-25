package com.sahu.runner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sahu.document.PersonDetails;
import com.sahu.service.IPersonDetailsMgmtService;

@Component
public class SpecialTypesTestRunner implements CommandLineRunner {

	@Autowired
	private IPersonDetailsMgmtService personDetailsMgmtService;

	@Override
	public void run(String... args) throws Exception {
		//Prepare Document object
		PersonDetails person = new PersonDetails();
		person.setPId(new Random().nextInt());
		person.setPName("Raja");
		person.setPAddress("Hyd");
		person.setDob(LocalDateTime.of(1998, 11, 24, 12, 35));
		person.setMaritalStatus(false);
		person.setMobileNumbers(Set.of(88888888l, 99999999l, 77777l));
		person.setNickNames(new String[] {"Raj", "King", "K"});
		person.setAcademics(List.of("10th", "+2", "BCA", "MCA"));
		person.setBankAccounts(Map.of("SBI", 7654356754L, "ICICI", 564356434L));
		Properties idDetails = new Properties();
		idDetails.put("Aadhaar", "4646424343");
		idDetails.put("Pan No", "6DB424S43");
		person.setIdDetails(idDetails);
		
		System.out.println(personDetailsMgmtService.registerPerson(person));
		
		personDetailsMgmtService.fetchAllPersons().forEach(System.out::println);
	}

}
