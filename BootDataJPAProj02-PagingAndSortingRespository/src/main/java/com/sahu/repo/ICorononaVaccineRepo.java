package com.sahu.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sahu.entity.CoronaVaccine;

public interface ICorononaVaccineRepo extends PagingAndSortingRepository<CoronaVaccine, Long> {

}

