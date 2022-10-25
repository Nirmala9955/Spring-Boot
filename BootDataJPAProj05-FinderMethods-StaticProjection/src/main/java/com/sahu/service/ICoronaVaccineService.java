package com.sahu.service;

import java.util.List;

import com.sahu.type.ResultView;

public interface ICoronaVaccineService {
	public List<ResultView> searchVaccinesByPrice(Double price);
}