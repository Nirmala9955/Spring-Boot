package com.sahu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.repo.ICorononaVaccineRepo;
import com.sahu.type.ResultView;

@Service("vaccineService")
public class CoronaVaccineServiceImpl implements ICoronaVaccineService {

	@Autowired
	private ICorononaVaccineRepo corononaVaccineRepo;

	@Override
	public List<ResultView> searchVaccinesByPrice(Double price) {
		return corononaVaccineRepo.findByPriceGreaterThanEqualOrderByPrice(price);
	}

}
