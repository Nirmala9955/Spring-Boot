package com.sahu.service;

import java.util.Date;
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
		return corononaVaccineRepo.searchVaccinesByCompany(company);
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByCompanies(String company1, String company2, String company3) {
		return corononaVaccineRepo.searchVaccinesByCompanies(company1, company2, company3);
	}

	@Override
	public List<Object[]> fetchVaccinesByNames(String name1, String name2) {
		return corononaVaccineRepo.searchVaccineDetailsByNames(name1, name2);
	}
	
	@Override
	public List<String> fetchVaccineNamesByPriceRange(Double min, Double max) {
		return corononaVaccineRepo.searchVaccineNamesByPriceRange(min, max);
	}

	@Override
	public Optional<CoronaVaccine> fetchVaccineByName(String vaccineName) {
		return corononaVaccineRepo.searchVaccineByName(vaccineName);
	}

	@Override
	public Object fetchVaccineDataByName(String vaccineName) {
		return corononaVaccineRepo.searchVaccineDataByName(vaccineName);
	}

	@Override
	public String fetchVaccineCountryByName(String vaccineName) {
		return corononaVaccineRepo.searchVaccineCountryByName(vaccineName);
	}

	@Override
	public Long fetchVaccinesCount() {
		return corononaVaccineRepo.getVaccinesCount();
	}

	@Override
	public Object fetchVaccineAggregateDetailsByPriceRange(Double min, Double max) {
		return corononaVaccineRepo.getVaccinesAggregateDataByPriceRange(min, max);
	}

	@Override
	public int ModifiyVaccinePriceByCountry(Double newPrice, String countryName) {
		return corononaVaccineRepo.updatePriceByCountry(newPrice, countryName);
	}

	@Override
	public int removeVaccinesByPriceRange(Double startPrice, Double endPrice) {
		return corononaVaccineRepo.deleteVaccineByPriceRange(startPrice, endPrice);
	}

	@Override
	public int registerVaccine(Long regNo, String company, String country, String name, Double price,
			Integer dosesCount) {
		return corononaVaccineRepo.insertVaccine(regNo, company, country, name, price, dosesCount);
	}

	@Override
	public Date fetchSystemDate() {
		return corononaVaccineRepo.getSystemDate();
	}

	@Override
	public int createTempTable() {
		return corononaVaccineRepo.createTempTable();
	}
	
}
