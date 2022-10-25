package com.sahu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahu.entity.CoronaVaccine;
import com.sahu.type.ResultView;

public interface ICorononaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {
	public List<ResultView> findByPriceGreaterThanEqualOrderByPrice(Double price);
}