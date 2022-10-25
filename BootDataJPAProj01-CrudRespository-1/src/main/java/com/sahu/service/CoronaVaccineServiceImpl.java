package com.sahu.service;

import java.util.Arrays;
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
	public String registerVaccine(CoronaVaccine coronaVaccine) {
		CoronaVaccine vaccine = null;
		if (coronaVaccine!=null)
			vaccine = corononaVaccineRepo.save(coronaVaccine);
		return vaccine!=null?"Vaccine Registered Successfully with "+vaccine.getRegNo():"Vaccine registration Failed";
	}

	@Override
	public Iterable<CoronaVaccine> registerBatch(Iterable<CoronaVaccine> vaccines) {
		if (vaccines!=null)
			return corononaVaccineRepo.saveAll(vaccines);
		else
			throw new IllegalArgumentException("Batch insertion is not done.");
	}

	@Override
	public Long getVaccineCount() {
		return corononaVaccineRepo.count();
	}

	@Override
	public Boolean checVaccineAvailabilityByRegNo(Long regNo) {
		return corononaVaccineRepo.existsById(regNo);
	}

	@Override
	public Iterable<CoronaVaccine> fetchAllDetails() {
		return corononaVaccineRepo.findAll();
	}

	@Override
	public Iterable<CoronaVaccine> fetchAllDetailsByIds(Iterable<Long> regNos) {
		return corononaVaccineRepo.findAllById(regNos);
	}

	@Override
	public Optional<CoronaVaccine> fetchVaccineById(Long regNo) {
		return corononaVaccineRepo.findById(regNo);
	}

	@Override
	public String removeVaccineByRegNo(Long regNo) {
		Optional<CoronaVaccine> optVaccine = corononaVaccineRepo.findById(regNo);
		if (optVaccine.isPresent()) {
			corononaVaccineRepo.deleteById(regNo);
			return "Record delete having Reg. No : "+regNo;
		}
		return "Record not found for deletion";
	}

	@Override
	public String removeVaccineByObject(CoronaVaccine vaccine) {
		Optional<CoronaVaccine> optVaccine = corononaVaccineRepo.findById(vaccine.getRegNo());
		if (optVaccine.isPresent()) {
			corononaVaccineRepo.delete(vaccine);
			return "Record delete having Reg. No : "+vaccine.getRegNo();
		}
		return "Record not found for deletion";
	}

	@Override
	public String removeVaccineByIds(Iterable<Long> ids) {
		Iterable<CoronaVaccine> listEntites = corononaVaccineRepo.findAllById(ids);
		if (((List)listEntites).size() == ((List)ids).size()) {
			corononaVaccineRepo.deleteAllById(ids);
			return ((List)listEntites).size()+"  no. of records are deleted";
		}
		return "Problem in deleting records";
	}

	@Override
	public String removeAllVaccines() {
		Long count = corononaVaccineRepo.count();
		if (count !=0) {
			corononaVaccineRepo.deleteAll();
			return count+" no. of records are deleted";
		}
		return "Table is empty to delete records";
	}

}

