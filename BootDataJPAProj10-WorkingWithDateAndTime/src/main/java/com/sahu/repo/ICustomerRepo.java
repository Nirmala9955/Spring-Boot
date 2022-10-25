package com.sahu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahu.entity.Customer;

public interface ICustomerRepo extends JpaRepository<Customer, Integer> {

}
