package com.sahu.repo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahu.entity.CoronaVaccine;

public interface ICorononaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {
	//SELECT REG_NO, NAME,COMPANY, COUNTRY, PRICE, REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE COMPANY=?
	public List<CoronaVaccine> findByCompany(String company);
	public List<CoronaVaccine> findByCompanyEquals(String company);
	public List<CoronaVaccine> findByCompanyIs(String company);
	
	//SELECT REG_NO, NAME,COMPANY, COUNTRY, PRICE, REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE PRICE<?
	public List<CoronaVaccine> findByPriceLessThan(Double price);

	//SELECT REG_NO, NAME,COMPANY, COUNTRY, PRICE, REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE PRICE BETWEEN ? AND ?
	public List<CoronaVaccine> findByPriceBetween(Double startPrice, Double endPrice);
	
	//SELECT REG_NO, NAME,COMPANY, COUNTRY, PRICE, REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE NAME LIKE ?/ 'P%'
	public List<CoronaVaccine> findByNameLike(String initChars);
	
	//SELECT REG_NO, NAME,COMPANY, COUNTRY, PRICE, REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE NAME LIKE ?%
	public List<CoronaVaccine> findByNameStartingWith(String startChars);
	
	//SELECT REG_NO, NAME,COMPANY, COUNTRY, PRICE, REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE NAME LIKE %?
	public List<CoronaVaccine> findByNameEndingWith(String endChars);
	
	//SELECT REG_NO, NAME,COMPANY, COUNTRY, PRICE, REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE NAME LIKE %?%
	public List<CoronaVaccine> findByNameContaining(String letters);

	//SELECT REG_NO, NAME,COMPANY, COUNTRY, PRICE, REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE COUNTRY IN (?, ?, ?)
	public List<CoronaVaccine> findByCountryIn(List<String> countries);

	//SELECT REG_NO, NAME,COMPANY, COUNTRY, PRICE, REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE COUNTRY NOT IN (?, ?, ?)
	public List<CoronaVaccine> findByCountryNotIn(List<String> countries);

	//SELECT REG_NO, NAME,COMPANY, COUNTRY, PRICE, REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE PRICE>? ORDER BY PRICE ASC;
	public List<CoronaVaccine> findByPriceGreaterThanOrderByPriceAsc(Double  startPrice);
	
	//SELECT REG_NO, NAME,COMPANY, COUNTRY, PRICE, REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE COUNTRY <> ? 
	public List<CoronaVaccine> findByCountryNot(String country);

	//SELECT REG_NO, NAME,COMPANY, COUNTRY, PRICE, REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE COUNTRY <> ? 
	public List<CoronaVaccine> findByCountryIsNot(String country);
	
	//SELECT REG_NO, NAME,COMPANY, COUNTRY, PRICE, REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE REG_NO =? 
	public Optional<CoronaVaccine> findByRegNo(Long regNo);

	//------------------------ Using multiple properties based condition
	
	//SELECT REG_NO, NAME,COMPANY, COUNTRY, PRICE, REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE NAME=? AND COUNTRY=?
	public List<CoronaVaccine> findByNameAndCountry(String name, String country);
	public List<CoronaVaccine> findByNameEqualsAndCountryEquals(String name, String country);
	
	//SELECT REG_NO, NAME,COMPANY, COUNTRY, PRICE, REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE NAME LIKE 'p%' OR PRICE BETWEEN ? AND ?
	public List<CoronaVaccine> findByNameLikeOrPriceBetween(String initChar, Double startPrice, Double endPrice);
	
	//SELECT REG_NO, NAME, COMPANY, COUNTRY, PRICE, REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE COUNTRY IN (?, ?, ?, ..) AND PRICE BETWEEN ? AND ?
	public List<CoronaVaccine> findByCountryInAndPriceBetween(Collection<String> countries, Double startPrice, Double endPrice);

	//SELECT REG_NO, NAME, COMPANY, COUNTRY, PRICE, REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE COUNTRY IN (?, ?, ?, ..) AND NAME IN (?, ?, ?) OR PRICE>=?
	public List<CoronaVaccine> findByCountryInAndNameInOrPriceGreaterThanEqual(Collection<String> countries, Collection<String> names, Double price);

}

 