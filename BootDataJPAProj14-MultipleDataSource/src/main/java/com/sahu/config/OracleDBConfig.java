package com.sahu.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.sahu.repo.prod",
						entityManagerFactoryRef = "createOracleEntityManagerFactoryBean",
						transactionManagerRef = "createOracleEntityManagerFactoryBean")
public class OracleDBConfig {
	
	@Bean
	@ConfigurationProperties(prefix = "oracle.datasource")
	@Primary
	public DataSource createOracleDS() {
		return DataSourceBuilder.create().build();
	} 
	
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean createOracleEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
		//Create map object having hibernate properties
		Map<String, Object> props = new HashMap<>();
		props.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		props.put("hibernate.hbm2ddl.auto", "update");
		//Create and return LocalContainerEntityManagerFactoryBean class object which means EntityManagerFactory ad the Spring bean
		return builder.dataSource(createOracleDS()) //DataSource
				.packages("com.sahu.model.prod") //Model class package
				.properties(props) //Hibernate properties.
				.build();
	}
	
	@Bean
	@Primary
	public PlatformTransactionManager createOracleTxMgmt(@Qualifier("createOracleEntityManagerFactoryBean") EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}
	
}