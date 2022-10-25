package com.sahu.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.sahu.listener.JobMonitoringListener;
import com.sahu.model.IExamResult;
import com.sahu.model.OExamResult;
import com.sahu.processor.ExamResultItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	//Listener
	@Bean
	public JobExecutionListener createListener() {
		return new JobMonitoringListener();
	}
	
	//Processor
	@Bean
	public ItemProcessor<IExamResult, OExamResult> createProcessor() {
		return new ExamResultItemProcessor();
	}
	
	//Reader
	/*@Bean
	public FlatFileItemReader<IExamResult> createReader() {
		FlatFileItemReader<IExamResult> reader = new FlatFileItemReader<IExamResult>();
		reader.setResource(new FileSystemResource("d:/csv/topbrain.csv"));
		reader.setLineMapper(new DefaultLineMapper<IExamResult>() {{
			setLineTokenizer(new DelimitedLineTokenizer() {
				{
					setDelimiter(",");
					setNames("id","dob", "percentage", "semester");
				}
			});
			setFieldSetMapper(new BeanWrapperFieldSetMapper<IExamResult>() {
				{
					setTargetType(IExamResult.class);
				}
			});
		}});
		return reader;
	}*/
	
	@Bean
	public FlatFileItemReader<IExamResult> createReader() {
		return new FlatFileItemReaderBuilder<IExamResult>()
				.name("csv")
				.resource(new FileSystemResource("d:/csv/topbrains.csv"))
				.delimited()
				.delimiter(",")
				.names("id","dob", "percentage", "semester")
				.targetType(IExamResult.class)
				.build();
	}

	//Writer
	/*@Bean
	public JpaItemWriter<OExamResult> createWriter() {
		JpaItemWriter<OExamResult> writer = new JpaItemWriter<OExamResult>();
		//Set EntityManager factory
		writer.setEntityManagerFactory(entityManagerFactory);
		return writer;
	}*/
	
	@Bean
	public JpaItemWriter<OExamResult> createWriter() {
		return new JpaItemWriterBuilder<OExamResult>()
				.entityManagerFactory(entityManagerFactory)
				.build();
	}
	
	//Step
	@Bean(name = "Setp1")
	public Step createStep1() {
		return stepBuilderFactory.get("Step1")
				.<IExamResult, OExamResult>chunk(3)
				.reader(createReader())
				.writer(createWriter())
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
