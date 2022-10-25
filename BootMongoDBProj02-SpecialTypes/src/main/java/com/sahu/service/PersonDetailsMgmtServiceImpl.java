package com.sahu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.document.PersonDetails;
import com.sahu.repository.IPersonDetailsRepo;

@Service("personDetailsService")
public class PersonDetailsMgmtServiceImpl implements IPersonDetailsMgmtService {

	@Autowired
	private IPersonDetailsRepo personDetailsRepo;
	
	@Override
	public String registerPerson(PersonDetails person) {
		return personDetailsRepo.save(person).getPName()+" details has saved";
	}

	@Override
	public List<PersonDetails> fetchAllPersons() {
		return personDetailsRepo.findAll();
	}

}
