package com.sahu.service;

import java.util.Optional;

import com.sahu.entity.MarriageSeeker;

public interface IMatrimonyServiceMgmt {
	public String registerMarriageSeeker(MarriageSeeker marriageSeeker);
	public Optional<MarriageSeeker> searchMarriageSeekerById(Long id);
}