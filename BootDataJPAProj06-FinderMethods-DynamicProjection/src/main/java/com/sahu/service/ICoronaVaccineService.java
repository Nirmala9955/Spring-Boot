package com.sahu.service;

import java.util.List;

import com.sahu.type.View;

public interface ICoronaVaccineService {
	public <T extends View> List<T> searchVaccinesByCompany(String company, Class<T> clazz);
}