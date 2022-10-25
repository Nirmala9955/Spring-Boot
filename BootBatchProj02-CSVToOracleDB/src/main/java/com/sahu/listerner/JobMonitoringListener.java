package com.sahu.listerner;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobMonitoringListener implements JobExecutionListener {

	private long startTime, endTime;
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		startTime = System.currentTimeMillis();
		System.out.println("Job is about to start at : "+new Date());
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		endTime = System.currentTimeMillis();
		System.out.println("Job has completed at : "+new Date());
		System.out.println("Job Execution time : "+(endTime-startTime)+"ms");
		System.out.println("Job Execution status : "+jobExecution.getStatus());
	}

}
