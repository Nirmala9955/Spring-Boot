package com.sahu.service;

import java.util.List;

import com.sahu.entity.CoronaVaccine;

public interface IVaccineMgmtService {
	public List<CoronaVaccine> searchVaccineByPriceRange(Double min, Double max);
	public String authenticate(String userName,String password);
	public Object[] getEmpDetailsByEno(int eno);
}
