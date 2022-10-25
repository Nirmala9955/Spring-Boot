package com.sahu.service;

import com.sahu.entity.CoronaVaccine;

public interface ICoronaVaccineService {
	public Iterable<CoronaVaccine> fetchDetails(boolean asc, String... properties);
	public Iterable<CoronaVaccine> fetchDetailsByPageNo(int pageNo, int  pageSize, boolean asc, String... properties);
	public void fetchDetailsByPagination(int pageSize);
}