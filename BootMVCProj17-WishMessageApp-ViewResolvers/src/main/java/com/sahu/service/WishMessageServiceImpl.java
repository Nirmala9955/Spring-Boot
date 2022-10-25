package com.sahu.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service("wishService")
public class WishMessageServiceImpl implements IWishMessageService {

	@Override
	public String generateWishMessage() {
		LocalDateTime dateTime = LocalDateTime.now();
		//get Current hour of the day
		int hour = dateTime.getHour();
		if (hour<12) 
			return "Good Morning";
		else if(hour<16)
			return "Good Afternoon";
		else if(hour<20)
			return "Good Evening";
		else 
			return "Good Night";
	}

}
