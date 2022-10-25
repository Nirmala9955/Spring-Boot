package com.sahu.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.sahu.listener.JobMonitoringListener;
import com.sahu.model.ExamResult;
import com.sahu.processor.ExamResultItemProcessor;

@EnableBatchProcessing
@Configuration
public class BatchConfig {

	@Autowired
	private DataSource dataSource;
	
	@Autowired   
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
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
	
	/*@Bean
	public JdbcCursorItemReader<ExamResult> createREader() {
		//Create object
		JdbcCursorItemReader<ExamResult> reader = new JdbcCursorItemReader<>();
		//Specify DataSource
		reader.setDataSource(dataSource);
		//Specify SQL query
		reader.setSql("SELECT ID,DOB,PERCENTAGE,SEMESTER FROM EXAM_RESULT");
		//Specify RowMapper
		//reader.setRowMapper(new ExamResultRowMapper());
		reader.setRowMapper((rs, rowNum)->{
			return new ExamResult(rs.getInt(1), rs.getDate(2), rs.getDouble(3), rs.getInt(4));
		});
		return reader;
	}*/
	
	@Bean
	public JdbcCursorItemReader<ExamResult> createReader() {
		return new JdbcCursorItemReaderBuilder<ExamResult>()
				.name("jdbc-reader")
				.dataSource(dataSource)
				.sql("SELECT ID,DOB,PERCENTAGE,SEMESTER FROM EXAM_RESULT")
				.beanRowMapper(ExamResult.class)//Internally use BeanPropertyRowMapper to convert the record of
				//RS to given Model class object but DB table column name and Model class properties must match
				.build();
	}
	
	//Writer
	@Bean
	public FlatFileItemWriter<ExamResult> createWriter(){
		FlatFileItemWriter<ExamResult> writer = new FlatFileItemWriter<ExamResult>();
		//Set Logical name
		//writer.setName("writer-csv");
		//Specify the destination CSV file location
		//writer.setResource(new ClassPathResource("topbrain.csv"));
		writer.setResource(new FileSystemResource("d:\\csv\\topbrain.csv"));
		//Specify LineAggregator
		writer.setLineAggregator(new DelimitedLineAggregator<ExamResult>() {
			{	
				//Delimeter
				setDelimiter(",");
				//Filed extractor
				setFieldExtractor(new BeanWrapperFieldExtractor<ExamResult>() {
					{
						setNames(new String[] {"id", "dob", "percentage", "semester"});
					}
				});
			}
			
		});
		return writer;
	}
	
	/*@Bean
	public FlatFileItemWriter<ExamResult> createWriter(){
		return  new FlatFileItemWriterBuilder<ExamResult>()
				.name("Line123")
				.resource(new ClassPathResource("topbrain.csv"))
				.lineSeparator("\r\n")
				.delimited().delimiter(",")
				.names("id", "dob", "percentage", "semester")
				.build();
	}*/
	
	//Step
	@Bean(name = "Step1")
	public Step createStep1() {
		return stepBuilderFactory.get("Step1")
				.<ExamResult, ExamResult>chunk(3)
				.reader(createReader())
				.writer(createWriter())
				.processor(createProcessor())
				.build();
	}
	
	@Bean(name = "Job1")
	public Job createJob1() {
		return jobBuilderFactory.get("Job1")
				.incrementer(new RunIdIncrementer())
				.listener(createListener())
				.start(createStep1())
				.build();
	}
}
