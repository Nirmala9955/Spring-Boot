package com.sahu.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sahu.listerner.JobMonitoringListener;
import com.sahu.processor.BookDetailsProcessor;
import com.sahu.reader.BookDetailsReader;
import com.sahu.writer.BookDetailsWriter;

@Configuration
@EnableBatchProcessing //Gives Spring batch features through autoconfiguration
//like giving InMemoryJobRepository, JobBuilderFactory, StepBuilderFactory and etc.
public class BatchConfig {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private BookDetailsWriter detailsWriter;
	
	@Autowired
	private BookDetailsReader detailsReader;
	
	@Autowired
	private BookDetailsProcessor detailsProcessor;
	
	@Autowired
	private JobMonitoringListener monitoringListener;
	
	//Create Step object using StepBuilderFactory
	@Bean(name = "step1")
	public Step createStep1() {
		System.out.println("BatchConfig.createStep1()");
		return stepBuilderFactory.get("step1")
					.<String, String>chunk(2)
					.reader(detailsReader)
					.writer(detailsWriter)
					.processor(detailsProcessor)
					.build();
	}
	
	//Create Job using JobBuilderFactory
	@Bean(name = "job1")
	public Job createJob() {
		System.out.println("BatchConfig.createJob()");
		return jobBuilderFactory.get("job1")
				.incrementer(new RunIdIncrementer())
				.listener(monitoringListener)
				.start(createStep1())
				.build();
	}
	
}
