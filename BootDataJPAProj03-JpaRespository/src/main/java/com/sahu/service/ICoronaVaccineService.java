package com.sahu.service;

import java.util.List;

import com.sahu.entity.CoronaVaccine;

public interface ICoronaVaccineService {
	public List<CoronaVaccine> searchVaccinesByGivenData(CoronaVaccine vaccine, boolean ascOrder, String... properties);
	public CoronaVaccine getVaccineByRegNo(Long regNo);
	public String removeVaccineByRegNos(Iterable<Long> regNos);
}