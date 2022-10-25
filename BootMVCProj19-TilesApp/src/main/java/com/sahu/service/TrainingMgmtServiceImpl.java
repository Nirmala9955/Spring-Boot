package com.sahu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.model.Faculty;
import com.sahu.repository.IFacultyRepo;

@Service("trainingService")
public class TrainingMgmtServiceImpl implements ITrainingMgmtService {

	@Autowired
	private IFacultyRepo facultyRepo;
	
	@Override
	public Iterable<Faculty> getAllFaculties() {	
		return facultyRepo.findAll();
	}

}
