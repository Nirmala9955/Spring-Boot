package com.sahu.service;

import java.util.List;

import com.sahu.entity.Tourist;
import com.sahu.exception.TouristNotFoundException;

public interface ITouristMgmtService {
	public String registerTourist(Tourist tourist);
	public List<Tourist> fetchAllTourist();
	public Tourist fetchTouristById(Integer tid) throws TouristNotFoundException;
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException;
	public String deleteTourist(Integer tid) throws TouristNotFoundException;
	public String updateTouristBudgetById(Integer tid, Float  hikePercent) throws TouristNotFoundException;
}
