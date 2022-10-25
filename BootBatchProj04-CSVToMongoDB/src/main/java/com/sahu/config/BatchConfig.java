package com.sahu.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.sahu.document.ExamResult;
import com.sahu.listener.JobMonitoringListener;
import com.sahu.processor.ExamResultItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private  MongoTemplate template;

	//Listener
	@Bean
	public JobExecutionListener createListener() {
		return new JobMonitoringListener();
	}
	
	//Processor
	@Bean
	public ItemProcessor<ExamResult, ExamResult> createProcessor() {
		return new ExamResultItemProcessor();
	}
	
	//Reader
	@Bean
	public FlatFileItemReader<ExamResult> createReader() {
		FlatFileItemReader<ExamResult> reader = new FlatFileItemReader<ExamResult>();
		reader.setResource(new FileSystemResource("d:/csv/topbrain.csv"));
		reader.setLineMapper(new DefaultLineMapper<ExamResult>() {{
			setLineTokenizer(new DelimitedLineTokenizer() {
				{
					setDelimiter(",");
					setNames("id","dob", "percentage", "semester");
				}
			});
			setFieldSetMapper(new BeanWrapperFieldSetMapper<ExamResult>() {
				{
					setTargetType(ExamResult.class);
				}
			});
		}});
		return reader;
	}
	
	//Writer
	@Bean
	public MongoItemWriter<ExamResult> createWriter() {
		MongoItemWriter<ExamResult> writer = new MongoItemWriter<ExamResult>();
		writer.setCollection("SuperBrains");
		writer.setTemplate(template);
		return writer;
	}
	
	//Step
	@Bean(name = "Setp1")
	public Step createStep1() {
		return stepBuilderFactory.get("Step1")
				.<ExamResult, ExamResult>chunk(3)
				.reader(createReader())
				.reader(createReader())
				.processor(createProcessor())
				.build();
	}
	
	//Job
	@Bean(name = "Job1")
	public Job createJob1() {
		return jobBuilderFactory.get("Job1")
				.incrementer(new  RunIdIncrementer())
				.listener(createListener())
				.start(createStep1())
				.build();
	}
	
}
