package com.sahu.service;

import com.sahu.entity.MarriageSeekerInfo;

public interface IMatrimonyMgmtService {
	public String registerProfile(MarriageSeekerInfo seekerInfo);
	public Iterable<MarriageSeekerInfo> getAllProfiles();
}	
