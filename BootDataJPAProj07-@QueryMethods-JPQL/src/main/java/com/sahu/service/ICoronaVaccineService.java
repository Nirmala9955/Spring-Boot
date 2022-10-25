package com.sahu.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.sahu.entity.CoronaVaccine;

public interface ICoronaVaccineService {
	public List<CoronaVaccine> fetchVaccinesByCompany(String company);
	
	public List<CoronaVaccine> fetchVaccinesByCompanies(String company1, String company2, String company3);
	public List<Object[]> fetchVaccinesByNames(String name1, String name2);
	public List<String> fetchVaccineNamesByPriceRange(Double min, Double max);
	
	public Optional<CoronaVaccine> fetchVaccineByName(String vaccineName);
	public Object fetchVaccineDataByName(String vaccineName);
	public String fetchVaccineCountryByName(String vaccineName);
	
	public Long fetchVaccinesCount();
	public Object fetchVaccineAggregateDetailsByPriceRange(Double min, Double max);

	public int ModifiyVaccinePriceByCountry(Double newPrice, String countryName);
	public int removeVaccinesByPriceRange(Double startPrice, Double endPrice);
	
	public int registerVaccine(Long regNo, String company, String country, String name, Double price, Integer dosesCount);
	public Date fetchSystemDate();
	public int createTempTable();
}