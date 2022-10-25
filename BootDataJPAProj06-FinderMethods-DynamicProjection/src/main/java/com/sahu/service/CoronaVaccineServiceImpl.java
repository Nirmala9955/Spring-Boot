package com.sahu.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.repo.ICorononaVaccineRepo;
import com.sahu.type.View;

@Service("vaccineService")
public class CoronaVaccineServiceImpl implements ICoronaVaccineService {

	@Autowired
	private ICorononaVaccineRepo corononaVaccineRepo;

	@Override
	public <T extends View> List<T> searchVaccinesByCompany(String company, Class<T> clazz) {
		return corononaVaccineRepo.findByCompanyOrderByCompanyDesc(company, clazz);
	}

}
