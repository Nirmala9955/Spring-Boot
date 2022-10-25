package com.sahu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahu.entity.CoronaVaccine;
import com.sahu.type.View;

public interface ICorononaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {
	public <T extends View> List<T> findByCompanyOrderByCompanyDesc(String company, Class<T> clazz);
}