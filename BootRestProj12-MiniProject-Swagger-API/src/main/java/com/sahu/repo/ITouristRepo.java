package com.sahu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahu.entity.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

}