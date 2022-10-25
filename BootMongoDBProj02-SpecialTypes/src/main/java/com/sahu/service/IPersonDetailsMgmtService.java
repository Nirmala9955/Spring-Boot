package com.sahu.service;

import java.util.List;

import com.sahu.document.PersonDetails;

public interface IPersonDetailsMgmtService {
	public String registerPerson(PersonDetails person);
	public List<PersonDetails> fetchAllPersons();
}
