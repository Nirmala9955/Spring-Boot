package com.sahu.interceptor;

import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class TimeOutCheckInterceptor implements HandlerInterceptor {
	
	public TimeOutCheckInterceptor() {
		System.out.println("TimeOutCheckInterceptor.TimeOutCheckInterceptor()");
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("TimeOutCheckInterceptor.preHandle()");
		//Check the timing
		LocalTime localTime = LocalTime.now();
		//Get current hour of the day
		int hour = localTime.getHour();
		if (hour<9 || hour>17) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/timeout.jsp");
			dispatcher.forward(request, response);
			return false;
		}
		return true;
	}
	
}
