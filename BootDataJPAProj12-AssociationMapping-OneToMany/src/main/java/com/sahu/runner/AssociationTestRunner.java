package com.sahu.runner;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sahu.entity.Person;
import com.sahu.entity.PhoneNumber;
import com.sahu.service.IPersonMgmtService;

@Component
public class AssociationTestRunner implements CommandLineRunner {
	
	@Autowired
	private IPersonMgmtService personMgmtService;

	@Override
	public void run(String... args) throws Exception {
		//------------------ Save Operation child to Parent ---------------------
		/*//Prepare object having associated child objects
		PhoneNumber ph1 = new PhoneNumber(9999999L, "Airtel", "Office");
		PhoneNumber ph2  = new PhoneNumber(888888888L, "Vodafone", "Residence");
		//Parent object
		Person person1 = new Person("Rajesh", "Hyd");
		//Parent to child
		ph1.setPerson(person1);
		ph2.setPerson(person1);
		//Child  to parent
		Set<PhoneNumber> phoneSet = Set.of(ph1, ph2);
		person1.setContactDetails(phoneSet);
		//Invoke Service method
		System.out.println(personMgmtService.savePerson(person1));
		*/
		//------------------ Save Operation child to Parent ---------------------
		/*//Child Objects
		PhoneNumber phone1 = new PhoneNumber(75757463343L, "Jio", "Office");
		PhoneNumber phone2  = new PhoneNumber(6734635334L, "Vodafone", "Residence");
		//Parent object
		Person person = new Person("Karan", "Hyd");
		//Add Parent to Child
		phone1.setPerson(person);
		phone2.setPerson(person);
		//Add Child to Parent
		Set<PhoneNumber> phones = Set.of(phone1, phone2);
		person.setContactDetails(phones);
		System.out.println(personMgmtService.savePhoneNumbers(phones));*/
	
		/*//----------------Load operation parent to child ---------------
		personMgmtService.fetchByPerson().forEach(person->{
			System.out.println("Parent : "+person);
			person.getContactDetails().forEach(System.out::println);
		});
		// ------------------- Load operation Child to parent
		personMgmtService.fetchByPhoneNumber().forEach(phoneNo ->  {
			System.out.println("Child : "+phoneNo);
			System.out.println("Parent : "+phoneNo.getPerson());
		});*/
		
		System.out.println(personMgmtService.deleteByPerson(24));
		System.out.println(personMgmtService.deleteAllPhoneNumbersOfAPerson(25));
	}

}
