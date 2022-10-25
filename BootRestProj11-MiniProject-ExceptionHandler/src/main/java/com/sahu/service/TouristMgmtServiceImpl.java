package com.sahu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.entity.Tourist;
import com.sahu.exception.TouristNotFoundException;
import com.sahu.repo.ITouristRepo;

@Service("touristService")
public class TouristMgmtServiceImpl implements ITouristMgmtService {
	
	@Autowired
	private ITouristRepo touristRepo;
	
	@Override
	public String registerTourist(Tourist tourist) {
		int idVal = touristRepo.save(tourist).getTid();
		return "Tourist has registered with id value - " + idVal;
	}

	@Override
	public List<Tourist> fetchAllTourist() {
		List<Tourist> listTourist = touristRepo.findAll();
		listTourist.sort((t1, t2) -> t1.getTid().compareTo(t2.getTid()));
		return listTourist;
	}

	@Override
	public Tourist fetchTouristById(Integer tid) throws TouristNotFoundException {
		return touristRepo.findById(tid).orElseThrow(() -> new TouristNotFoundException(tid + " tourist not found"));
	}

	@Override
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException {
		Optional<Tourist> optTourist = touristRepo.findById(tourist.getTid());
		if (optTourist.isPresent()) {
			// save(-) performs either save object or update object operation
			touristRepo.save(tourist);
			return tourist.getTid() + " tourist has updated";
		} else {
			throw new TouristNotFoundException(tourist.getTid() + " tourist not found");
		}
	}

	@Override
	public String deleteTourist(Integer tid) throws TouristNotFoundException {
		Optional<Tourist> optTourist = touristRepo.findById(tid);
		if (optTourist.isPresent()) {
			touristRepo.delete(optTourist.get());
			return tid + " tourist has deleted";
		} else {
			throw new TouristNotFoundException(tid + " tourist not found");
		}	
	}

	@Override
	public String updateTouristBudgetById(Integer tid, Float hikePercent) throws TouristNotFoundException {
		Optional<Tourist> optTourist = touristRepo.findById(tid);
		if (optTourist.isPresent()) {
			Tourist tourist = optTourist.get();
			tourist.setBudget(tourist.getBudget()+(tourist.getBudget()*(hikePercent/100)));
			touristRepo.save(tourist);
			return "Tourist budget has updated";
		} else {
			throw new TouristNotFoundException(tid + " tourist not found");
		}	
	}

}
