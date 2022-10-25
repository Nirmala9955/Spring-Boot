package com.sahu.service;

import java.util.List;

import com.sahu.document.DrivingLicense;
import com.sahu.document.Person;

public interface IRTOMgmtService {
	public String savePersonWithLicense(Person person); 
	public String saveLicenseWithPerson(DrivingLicense license);
	
	public List<Person> fetchAllPersons();
	public List<DrivingLicense> fetchAllDrivingLicenses();
}
