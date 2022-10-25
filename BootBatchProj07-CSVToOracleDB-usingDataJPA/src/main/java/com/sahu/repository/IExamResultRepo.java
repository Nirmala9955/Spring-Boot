package com.sahu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahu.model.OExamResult;

public interface IExamResultRepo extends JpaRepository<OExamResult, Integer> {

}
