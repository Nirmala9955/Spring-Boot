package com.sahu.service;

import java.util.List;
import java.util.Optional;

import com.sahu.entity.CoronaVaccine;

public interface ICoronaVaccineService {
	public List<CoronaVaccine> fetchVaccinesByCompany(String company);
	
	public List<CoronaVaccine> fetchVaccinesByPriceLessThan(Double price);
	public List<CoronaVaccine> fetchVaccinesByPriceBetween(Double startPrice, Double endPrice);
	public List<CoronaVaccine> fetchVaccinesByNameLike(String initChars);
	public List<CoronaVaccine> fetchVaccinesByNameStartingWith(String startChars);
	public List<CoronaVaccine> fetchVaccinesByNameEndingWith(String endChars);
	public List<CoronaVaccine> fetchVaccinesByNameContaining(String letters);
	public List<CoronaVaccine> fetchVaccinesByCountryIn(String... countries);
	public List<CoronaVaccine> fetchVaccinesByCountryNotIn(List<String> countries);
	public List<CoronaVaccine> searchVaccinesByPriceAscOrder(Double price);
	public List<CoronaVaccine> searchVaccinesNotFromCountry(String country);
	public Optional<CoronaVaccine> getVaccineByRegNo(Long regNo);
	
	public List<CoronaVaccine> searchVaccinesByNameAndCountry(String name, String country);
	public List<CoronaVaccine> searchVaccinesByNameInitCharOrPriceRang(String initChars, Double startRang, Double endRange);
	public List<CoronaVaccine> searchVaccinesByCountriesAndPriceRang(List<String> countries, Double startRang, Double endRange);
	public List<CoronaVaccine> searchVaccinesByCountriesAndNamesOrByPrice(List<String> countries, List<String> names, Double price);
	
}