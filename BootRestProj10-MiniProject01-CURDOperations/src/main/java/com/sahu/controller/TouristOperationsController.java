package com.sahu.controller;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahu.entity.Tourist;
import com.sahu.service.ITouristMgmtService;

@RestController
@RequestMapping("/tourist")
public class TouristOperationsController {

	@Autowired
	private ITouristMgmtService touristMgmtService;
	
	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist){
		try {
			//use service
			String resultMsg = touristMgmtService.registerTourist(tourist);
			//HttpStatus.CREATED - 201 content created sucessfully
			return new ResponseEntity<String>(resultMsg, HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Problem in tourist enrollment", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> displayAllTourist(){
		try {
			List<Tourist> listTourist = touristMgmtService.fetchAllTourist();
			return new ResponseEntity<List<Tourist>>(listTourist, HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<String>("Problem in fetchinhg tourists", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> displayTouristById(@PathVariable("id") Integer id){
		try {
			Tourist tourist = touristMgmtService.fetchTouristById(id);
			return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> modifyTourist(@RequestBody Tourist tourist){
		try {
			String msg = touristMgmtService.updateTouristDetails(tourist);
			return new ResponseEntity<String>(msg, HttpStatus.OK); 
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeTourist(@PathVariable("id") Integer tid) {
		try {
			String msg = touristMgmtService.deleteTourist(tid);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} 
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PatchMapping("/budgetModify/{id}/{hike}")
	public ResponseEntity<String> ModifyTouristBudget(@PathVariable("id") Integer id, @PathVariable("hike") Float hikePercent) {
		try {
			//use service
			String msg = touristMgmtService.updateTouristBudgetById(id, hikePercent);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} 
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
