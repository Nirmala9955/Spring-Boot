package com.sahu.service;

import java.util.List;

import org.hibernate.query.criteria.internal.expression.ConcatExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sahu.entity.CoronaVaccine;
import com.sahu.repo.ICorononaVaccineRepo;

@Service("vaccineService")
public class CoronaVaccineServiceImpl implements ICoronaVaccineService {

	@Autowired
	private ICorononaVaccineRepo corononaVaccineRepo;

	@Override
	public List<CoronaVaccine> searchVaccinesByGivenData(CoronaVaccine vaccine, boolean ascOrder,
			String... properties) {
		// Prepare Example object
		Example example = Example.of(vaccine);
		//Prepare Sort Object
		Sort sort = Sort.by(ascOrder?Direction.ASC:Direction.DESC, properties);
		List<CoronaVaccine> listVaccines = corononaVaccineRepo.findAll(example, sort);
		return listVaccines;
	}

	@Override
	public CoronaVaccine getVaccineByRegNo(Long regNo) {
		return corononaVaccineRepo.getById(regNo);
	}

	@Override
	public String removeVaccineByRegNos(Iterable<Long> regNos) {
		Iterable<CoronaVaccine> listVaccines = corononaVaccineRepo.findAllById(regNos);
		if (((List<CoronaVaccine>) listVaccines).size()!=0) {
			corononaVaccineRepo.deleteAllByIdInBatch(regNos);
			return ((List<CoronaVaccine>) listVaccines).size()+" no. of records are deleted";
		}
		return "Records not found for deletion.";	
	}
	
}

