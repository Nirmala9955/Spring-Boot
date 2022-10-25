package com.sahu.repo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sahu.entity.CoronaVaccine;

public interface ICorononaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {
	// @Query("FROM com.sahu.entity.CoronaVaccine WHERE company=?1")
	// @Query("FROM CoronaVaccine WHERE company=?1")
	// @Query("FROM CoronaVaccine as cv WHERE cv.company=?1")
	// @Query("SELECT cv FROM CoronaVaccine as cv WHERE cv.company=?1")
	// @Query("SELECT cv FROM CoronaVaccine as cv WHERE cv.company=?") throws
	// java.lang.IllegalArgumentException: JDBC style parameters (?) are not
	// supported for JPA queries.
	// @Query("FROM CoronaVaccine WHERE company=:vendor")
	// public List<CoronaVaccine> searchVaccinesByCompany(String vendor);

	@Query("FROM CoronaVaccine WHERE company=:comp")
	public List<CoronaVaccine> searchVaccinesByCompany(@Param("comp") String vendor);

	
	// --------------------- Select Query performing bulk operation ------------------------
	// Entity Query selecting all column values
	@Query("FROM CoronaVaccine WHERE company IN(:company1, :company2, :company3) ORDER BY company")
	public List<CoronaVaccine> searchVaccinesByCompanies(String company1, String company2, String company3);
	// Here we can not take List<String> companies, String... companies (var args)/
	// String[] companies as the param type

	// Scalar Query selecting multiple column values
	@Query("SELECT name, company, price FROM CoronaVaccine WHERE name IN(:name1, :name2)")
	public List<Object[]> searchVaccineDetailsByNames(String name1, String name2);

	// Scalar Query selecting One column values
	@Query("SELECT name FROM CoronaVaccine WHERE price BETWEEN :min AND :max")
	public List<String> searchVaccineNamesByPriceRange(Double min, Double max);

	
	// --------------------- Select Query performing Single row operation ------------------------
	// Entity Query giving Single row
	@Query("FROM CoronaVaccine WHERE name=:vaccineName")
	public Optional<CoronaVaccine> searchVaccineByName(String vaccineName);

	// Scalar Query giving multiple column values of Single row
	@Query("SELECT name, company, country FROM CoronaVaccine WHERE name=:vaccineName")
	public Object searchVaccineDataByName(String vaccineName);

	// Scalar Query giving single column values of Single row
	@Query("SELECT country FROM CoronaVaccine WHERE name=:vaccineName")
	public String searchVaccineCountryByName(String vaccineName);
	
	
	// ---------------- Aggregate function -------------------
	@Query("SELECT COUNT(*) FROM CoronaVaccine")
	public Long getVaccinesCount();
	
	@Query("SELECT COUNT(*), MAX(price), MIN(price), sum(price), AVG(price) FROM CoronaVaccine WHERE price>=:min AND price<=:max")
	public Object getVaccinesAggregateDataByPriceRange(Double min, Double max);
	
	
	// --------------- Non-select operations ----------------
	@Modifying
	@Query("UPDATE CoronaVaccine SET price=:newPrice WHERE country=:countryName")
	@Transactional
	public int updatePriceByCountry(Double newPrice, String countryName);
	
	@Modifying
	@Query("DELETE FROM CoronaVaccine WHERE price BETWEEN :startPrice AND :endPrice")
	@Transactional
	public int deleteVaccineByPriceRange(Double startPrice, Double endPrice);
	
	
	// --------------------------Native SQL queries -------------------
	@Modifying
	@Query(value="INSERT INTO CORONA_VACCINE VALUES(?, ?, ?, ?, ?, ?)", nativeQuery = true)
	@Transactional
	public int insertVaccine(Long regNo, String company, String country, String name, Double price, Integer dosesCount);
	
	@Query(value="SELECT SYSDATE FROM DUAL", nativeQuery = true)
	public Date getSystemDate();
	
	@Modifying
	@Query(value="CREATE TABLE TEMP(COL1 NUMBER(5), COL2 VARCHAR2(20))", nativeQuery = true)
	@Transactional
	public int createTempTable();
}