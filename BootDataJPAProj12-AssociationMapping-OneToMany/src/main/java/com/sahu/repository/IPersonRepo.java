package com.sahu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahu.entity.Person;

public interface IPersonRepo extends JpaRepository<Person, Integer> {

}
