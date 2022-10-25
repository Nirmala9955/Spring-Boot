package com.sahu.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.entity.Person;
import com.sahu.entity.PhoneNumber;
import com.sahu.repository.IPersonRepo;
import com.sahu.repository.IPhoneNumberRepo;

@Service("personMgmtService")
public class PersonMgmtServiceImpl implements IPersonMgmtService {
	
	@Autowired
	private IPersonRepo personRepo;
	
	@Autowired
	private IPhoneNumberRepo phoneNumberRepo;
	
	@Override
	public String savePerson(Person person) {
		int idVAl= personRepo.save(person).getPId();
		return "Person and his phone numbers has saved with the id value : "+idVAl;
	}

	@Override
	public String savePhoneNumbers(Iterable<PhoneNumber> phoneNos) {
		for (PhoneNumber phone : phoneNos) {
			phoneNumberRepo.save(phone);
		}
		return ((Set<PhoneNumber>) phoneNos).size()+" phone numbers has saved.";
	}

	@Override
	public Iterable<Person> fetchByPerson() {
		return personRepo.findAll();
	}

	@Override
	public Iterable<PhoneNumber> fetchByPhoneNumber() {
		return phoneNumberRepo.findAll();
	}

	
	@Override
	public String deleteByPerson(Integer personId) {
		//Load parent object
		Optional<Person> optPerson = personRepo.findById(personId);
		if(optPerson.isPresent()) {
			personRepo.delete(optPerson.get());
			return "Person add his Phone Numbers has deleted";	
		}
		return "Person not found";
	}

	@Override
	public String deleteAllPhoneNumbersOfAPerson(Integer personId) {
		//Load Parent object
		Optional<Person> optPerson = personRepo.findById(personId);
		if(optPerson.isPresent()) {
			//Get all child of a Parent
			Set<PhoneNumber> phoneNos = optPerson.get().getContactDetails();
			//Delete all child
			phoneNos.forEach(phone -> phone.setPerson(null));
			phoneNumberRepo.deleteAllInBatch(phoneNos);
			return phoneNos.size()+" Phone number of "+personId+" person has deleted";
		}
		return personId+" person not found";
	}

}
