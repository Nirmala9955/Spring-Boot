package com.sahu.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sahu.model.Faculty;

public interface IFacultyRepo extends PagingAndSortingRepository<Faculty, Integer> {

}
