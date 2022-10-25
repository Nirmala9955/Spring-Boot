package com.sahu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.entity.MarriageSeekerInfo;
import com.sahu.repository.IMarriageSeekerInfoRepo;

@Service("matrimonyService")
public class MatrimonyMgmtService implements IMatrimonyMgmtService {

	@Autowired
	private IMarriageSeekerInfoRepo marriageSeekerInfoRepo;
	
	@Override
	public String registerProfile(MarriageSeekerInfo seekerInfo) {
		return marriageSeekerInfoRepo.save(seekerInfo).getProfileName()+" details has registered";
	}

	@Override
	public Iterable<MarriageSeekerInfo> getAllProfiles() {
		return marriageSeekerInfoRepo.findAll();
	}

}
