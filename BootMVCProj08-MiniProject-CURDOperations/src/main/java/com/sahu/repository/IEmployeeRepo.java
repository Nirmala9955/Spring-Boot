package com.sahu.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sahu.model.Employee;

public interface IEmployeeRepo extends PagingAndSortingRepository<Employee, Integer> {

}
