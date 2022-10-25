package com.sahu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.entity.MarriageSeeker;
import com.sahu.repo.IMatrimonyRepo;

@Service("matrimonyService")
public class MatrimonyServiceImpl implements IMatrimonyServiceMgmt {

	@Autowired
	private IMatrimonyRepo matrimonyRepo;
	
	@Override
	public String registerMarriageSeeker(MarriageSeeker marriageSeeker) {
		return "Marriage Seeker infromation has Saved with id value : "+matrimonyRepo.save(marriageSeeker).getId();
	}

	@Override
	public Optional<MarriageSeeker> searchMarriageSeekerById(Long id) {
		return matrimonyRepo.findById(id);
	}

}
