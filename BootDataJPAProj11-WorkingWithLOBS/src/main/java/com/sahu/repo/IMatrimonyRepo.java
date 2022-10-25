package com.sahu.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sahu.entity.MarriageSeeker;

public interface IMatrimonyRepo extends PagingAndSortingRepository<MarriageSeeker, Long> {

}