package com.yl.spring.main;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yl.spring.ApplicationConfig;
import com.yl.spring.annotation.service.RoleDataSourceService;
import com.yl.spring.pojo.Role;

public class MainTest {

	
	public static void main(String[] args) {
		
		Logger logger = Logger.getLogger(MainTest.class);
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		RoleDataSourceService service = context.getBean(RoleDataSourceService.class);
		Role role = service.getRole(2l);
		System.err.println(role);
		context.close();
	}
}
