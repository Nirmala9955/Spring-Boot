package com.sahu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahu.entity.CoronaVaccine;

public interface ICorononaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {

}

