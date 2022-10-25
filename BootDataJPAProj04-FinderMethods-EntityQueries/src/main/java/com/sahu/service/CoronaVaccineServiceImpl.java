package com.sahu.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.entity.CoronaVaccine;
import com.sahu.repo.ICorononaVaccineRepo;

@Service("vaccineService")
public class CoronaVaccineServiceImpl implements ICoronaVaccineService {

	@Autowired
	private ICorononaVaccineRepo corononaVaccineRepo;

	@Override
	public List<CoronaVaccine> fetchVaccinesByCompany(String company) {
		//return corononaVaccineRepo.findByCompany(company);
		//return corononaVaccineRepo.findByCompanyEquals(company);
		return corononaVaccineRepo.findByCompanyIs(company);
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByPriceLessThan(Double price) {
		return corononaVaccineRepo.findByPriceLessThan(price);
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByPriceBetween(Double startPrice, Double endPrice) {
		return corononaVaccineRepo.findByPriceBetween(startPrice, endPrice);
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByNameLike(String initChars) {
		return corononaVaccineRepo.findByNameLike(initChars);
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByNameStartingWith(String startChars) {
		return corononaVaccineRepo.findByNameStartingWith(startChars);
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByNameEndingWith(String endChars) {
		return corononaVaccineRepo.findByNameEndingWith(endChars);
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByNameContaining(String letters) {
		return corononaVaccineRepo.findByNameContaining(letters);
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByCountryIn(String... countries) {
		return corononaVaccineRepo.findByCountryIn(Arrays.asList(countries));
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByCountryNotIn(List<String> countries) {
		return corononaVaccineRepo.findByCountryNotIn(countries);
	}

	@Override
	public List<CoronaVaccine> searchVaccinesByPriceAscOrder(Double price) {
		return corononaVaccineRepo.findByPriceGreaterThanOrderByPriceAsc(price);
	}

	@Override
	public List<CoronaVaccine> searchVaccinesNotFromCountry(String country) {
		//return corononaVaccineRepo.findByCountryNot(country);
		return corononaVaccineRepo.findByCountryIsNot(country);
	}

	@Override
	public Optional<CoronaVaccine> getVaccineByRegNo(Long regNo) {
		return corononaVaccineRepo.findByRegNo(regNo);
	}

	//---------------------
	
	@Override
	public List<CoronaVaccine> searchVaccinesByNameAndCountry(String name, String country) {
		//return corononaVaccineRepo.findByNameAndCountry(name, country);
		return corononaVaccineRepo.findByNameEqualsAndCountryEquals(name, country);
	}

	@Override
	public List<CoronaVaccine> searchVaccinesByNameInitCharOrPriceRang(String initChars, Double startRang,
			Double endRange) {
		return corononaVaccineRepo.findByNameLikeOrPriceBetween(initChars, startRang, endRange);
	}

	@Override
	public List<CoronaVaccine> searchVaccinesByCountriesAndPriceRang(List<String> countries, Double startRang,
			Double endRange) {
		return corononaVaccineRepo.findByCountryInAndPriceBetween(countries, startRang, endRange);
	}

	@Override
	public List<CoronaVaccine> searchVaccinesByCountriesAndNamesOrByPrice(List<String> countries, List<String> names,
			Double price) {
		return corononaVaccineRepo.findByCountryInAndNameInOrPriceGreaterThanEqual(countries, names, price);
	}

		
}

