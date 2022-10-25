package com.sahu.service;

import java.util.Optional;

import com.sahu.entity.CoronaVaccine;

public interface ICoronaVaccineService {
	public String registerVaccine(CoronaVaccine coronaVaccine);
	public Iterable<CoronaVaccine> registerBatch(Iterable<CoronaVaccine> vaccines);
	public Long getVaccineCount();
	public Boolean checVaccineAvailabilityByRegNo(Long regNo);
	public Iterable<CoronaVaccine> fetchAllDetails();
	public Iterable<CoronaVaccine> fetchAllDetailsByIds(Iterable<Long> regNos);
	public Optional<CoronaVaccine> fetchVaccineById(Long regNo);
	
	public String removeVaccineByRegNo(Long regNo);
	public String removeVaccineByObject(CoronaVaccine vaccine);
	public String removeVaccineByIds(Iterable<Long> ids);
	public String removeAllVaccines();
	
}