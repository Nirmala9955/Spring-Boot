package com.sahu.service;

import com.sahu.entity.Person;
import com.sahu.entity.PhoneNumber;

public interface IPersonMgmtService {
	public String savePerson(Person person);
	public String savePhoneNumbers(Iterable<PhoneNumber> phoneNos);
	
	public Iterable<Person> fetchByPerson();
	public Iterable<PhoneNumber> fetchByPhoneNumber();
	
	public String deleteByPerson(Integer personId);
	public String deleteAllPhoneNumbersOfAPerson(Integer personId);
}
