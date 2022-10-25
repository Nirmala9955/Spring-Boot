package com.sahu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.document.DrivingLicense;
import com.sahu.document.Person;
import com.sahu.repository.IDrivingLicenseRepo;
import com.sahu.repository.IPersonRepo;

@Service("RTOService")
public class RTOMgmtServiceImpl implements IRTOMgmtService {
	
	@Autowired
	private IPersonRepo personRepo;
	
	@Autowired
	private IDrivingLicenseRepo drivingLicenseRepo;
	
	@Override
	public String savePersonWithLicense(Person person) {
		return person.getPName()+"'s details has saved with his License No. : "+personRepo.save(person).getLicense().getLId();
	}

	@Override
	public String saveLicenseWithPerson(DrivingLicense license) {
		return drivingLicenseRepo.save(license).getPerson().getPName()+"'s details has saved with his License No. : "+license.getLId();
	}

	@Override
	public List<Person> fetchAllPersons() {
		return personRepo.findAll();
	}

	@Override
	public List<DrivingLicense> fetchAllDrivingLicenses() {
		return drivingLicenseRepo.findAll();
	}

}
