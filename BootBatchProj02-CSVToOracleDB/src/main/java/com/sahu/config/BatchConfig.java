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
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.sahu.listerner.JobMonitoringListener;
import com.sahu.model.Employee;
import com.sahu.processor.EmployeeInfoItemProcessor;

@Configuration
@EnableBatchProcessing
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
	
	//ItemProcessor
	@Bean
	public ItemProcessor<Employee, Employee> createProcessor() {
		return new EmployeeInfoItemProcessor();
	}
	
	//Way #1 of ItemReader creation  
	@Bean
	public ItemReader<Employee> createReader() {
		//Create object for FlatFileItemReader
		FlatFileItemReader<Employee> reader = new FlatFileItemReader<Employee>();
		//Set source CSV file location 
		reader.setResource(new ClassPathResource("Employee_Details.csv"));
		//Set LineMapper
		reader.setLineMapper(new DefaultLineMapper<Employee>(){
			{
				//Set LineTokenizer
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setDelimiter(",");
						setNames("empno", "ename", "salary", "eaddress");
					}
				});
				//Set FieldSetMapper to write each line content to model class object
				setFieldSetMapper(new BeanWrapperFieldSetMapper<Employee>() {
					{
						setTargetType(Employee.class);
					}
				});
			}
		});
		return reader;
	}	

	//Way #2 of ItemReader creation
	@Bean
	public ItemReader<Employee> createReader1() {
		//Create object for FlatFileItemReader
		FlatFileItemReader<Employee> reader = new FlatFileItemReader<Employee>();
		//Set source CSV file location 
		reader.setResource(new ClassPathResource("Employee_Details.csv"));
		//Line Mapper
		DefaultLineMapper<Employee> lineMapper = new DefaultLineMapper<Employee>();
		//Line Tokenizer
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setNames("empno", "ename", "salary", "eaddress");
		//Line Tokenizer
		BeanWrapperFieldSetMapper<Employee> setMapper = new BeanWrapperFieldSetMapper<Employee>();
		setMapper.setTargetType(Employee.class);
		//Add Line Tokenize, Line Tokenizer to Line Mapper
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(setMapper);
		//add line mapper to reader
		reader.setLineMapper(lineMapper);
		return reader;
	}
	
	//Way #3 of ItemReader creation
	@Bean
	public ItemReader<Employee> createReader2() { 
		return new FlatFileItemReaderBuilder<Employee>()
				.name("file-reader")
				.resource(new ClassPathResource("Employee_Details.csv"))
				.delimited().delimiter(",") //makes us to use DefaultLineMapper, DelimitedLineTokenizer
				.names("empno", "ename", "salary", "eaddress")
				.targetType(Employee.class)
				.build();
	}
	
	//Way #1 of ItemWriter creation
	@Bean
	public ItemWriter<Employee> createWriter(){
		JdbcBatchItemWriter<Employee> writer = new JdbcBatchItemWriter<Employee>();
		//Set Datasource
		writer.setDataSource(dataSource);
		//set SQL query with named params
		writer.setSql("INSERT INTO BATCH_EMPLOYEE VALUES(:empno,:ename,:salary,:eaddress,:grossSalary,:netSalary)");
		//Set Model class object as SqlParameterSourceProvider (here named parameter names and model class object property name must same)
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>());
		return writer;
	}

	//Way #2 of ItemWriter creation
	@Bean
	public ItemWriter<Employee> createWriter1() {
		return new JdbcBatchItemWriterBuilder<Employee>()
				.dataSource(dataSource)
				.sql("INSERT INTO BATCH_EMPLOYEE VALUES(:empno,:ename,:salary,:eaddress,:grossSalary,:netSalary)")
				.beanMapped() //makes to use BeanPropertyItemSqlParameterSourceProvider
				.build();
				
	}
	
	@Bean("step1")
	public Step createStep1() {
		return stepBuilderFactory.get("step1")
				.<Employee, Employee>chunk(3)
				.reader(createReader())
				.writer(createWriter())
				.processor(createProcessor())
				.build();
	}
	
	@Bean(name = "job1")
	public Job createJob1() {
		return jobBuilderFactory.get("job1")
				.incrementer(new RunIdIncrementer())
				.listener(createListener())
				.start(createStep1())
				.build();
	}
	
}