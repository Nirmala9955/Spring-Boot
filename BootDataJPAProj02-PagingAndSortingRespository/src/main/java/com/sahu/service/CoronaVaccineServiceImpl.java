package com.sahu.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sahu.entity.CoronaVaccine;
import com.sahu.repo.ICorononaVaccineRepo;

@Service("vaccineService")
public class CoronaVaccineServiceImpl implements ICoronaVaccineService {

	@Autowired
	private ICorononaVaccineRepo corononaVaccineRepo;
	
	@Override
	public Iterable<CoronaVaccine> fetchDetails(boolean asc, String... properties) {
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC, properties);
		Iterable<CoronaVaccine> listEntities = corononaVaccineRepo.findAll(sort);
		return listEntities;
	}

	@Override
	public Iterable<CoronaVaccine> fetchDetailsByPageNo(int pageNo, int pageSize, boolean asc, String... properties) {
		//create pageable object having inputs
		Pageable pageable = PageRequest.of(pageNo, pageSize,
				asc?Direction.ASC:Direction.DESC, properties);
		Page<CoronaVaccine> page = corononaVaccineRepo.findAll(pageable);
		return page.getContent();
	}

	@Override
	public void fetchDetailsByPagination(int pageSize) {
		// get total records count
		long count = corononaVaccineRepo.count();
		//Decides the pages count
		long pagesCount = count/pageSize;
		pagesCount = (count%pageSize==0)?pagesCount:++pagesCount;
		
		for (int i = 0; i < pagesCount; i++) {
			Pageable pageable = PageRequest.of(i, pageSize);
			Page<CoronaVaccine> page = corononaVaccineRepo.findAll(pageable);
			page.getContent().forEach(System.out::println);
			System.out.println("---------- "+(i+1)+" of "+page.getTotalPages()+" ------------");
		}
		
	}

}

