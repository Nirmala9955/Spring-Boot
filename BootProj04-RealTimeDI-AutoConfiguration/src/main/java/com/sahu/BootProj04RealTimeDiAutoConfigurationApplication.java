package com.sahu;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.sahu.controller.MainController;
import com.sahu.vo.EmployeeVO;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, JdbcTemplateAutoConfiguration.class})
public class BootProj04RealTimeDiAutoConfigurationApplication {

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
		// Get IoC container
		ApplicationContext ctx = SpringApplication.run(BootProj04RealTimeDiAutoConfigurationApplication.class, args);
		
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
