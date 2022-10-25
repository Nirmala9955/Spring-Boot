package com.sahu;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sahu.controller.MainController;
import com.sahu.vo.EmployeeVO;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, JdbcTemplateAutoConfiguration.class})
public class BootProj04RealTimeDiAutoConfigurationApplication {
	
	@Autowired
	private Environment env;
	
	@Bean(name = "cds")
	@Profile({"uat", "default"})
	public ComboPooledDataSource createC3P0DS() throws Exception {
		System.out.println("BootProj04RealTimeDiAutoConfigurationApplication.createC3P0DS()");
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setDriverClass(env.getProperty("spring.datasource.driver-class-name"));
		comboPooledDataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
		comboPooledDataSource.setUser(env.getProperty("spring.datasource.username"));
		comboPooledDataSource.setPassword(env.getProperty("spring.datasource.password"));
		return comboPooledDataSource;
	}
	
	@Bean(name = "tcp")
	@Profile("default")
	public DataSource createTomcateCPDS() throws Exception {
		System.out.println("BootProj04RealTimeDiAutoConfigurationApplication.createTomcateCPDS()");
		DataSource tcpds = new DataSource();
		tcpds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		tcpds.setUrl("jdbc:mysql:///ntspbms714db");
		tcpds.setUsername("root");
		tcpds.setPassword("root");
		return tcpds;
	}

	public static void main(String[] args) {
		// Read inputs from user
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Desgination count : ");
		int count = sc.nextInt();
		String desgs[] = null;
		if (count >= 1) {
			desgs = new String[count];
		} else {
			System.out.println("Invalid desgination count");
			return;
		}
		for (int i = 0; i < count; i++) {
			System.out.print("Enter designation " + (i + 1) + " : ");
			desgs[i] = sc.next();
		}
		
		SpringApplication application = new SpringApplication(BootProj04RealTimeDiAutoConfigurationApplication.class);
		application.setAdditionalProfiles("uat");
		
		// Get IoC container
		ApplicationContext ctx = application.run(args);
		
		//Get controller class object
		MainController controller = ctx.getBean("mainController", MainController.class);
		//Invoke method
		try {
			List<EmployeeVO> listVO = controller.showEmpsByDesgs(desgs);
			System.out.println(Arrays.toString(desgs));
			listVO.forEach(System.out::println);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some internal problem : "+e.getMessage());
		}
		//close IoC container
		((ConfigurableApplicationContext) ctx).close();
	}

}
