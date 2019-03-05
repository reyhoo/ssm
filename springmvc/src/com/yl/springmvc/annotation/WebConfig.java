//package com.yl.springmvc.annotation;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
//import com.yl.springmvc.App;
//
//@Configuration
//@ComponentScan(basePackageClasses=App.class)
//@EnableWebMvc
//@EnableTransactionManagement
//public class WebConfig {
//
//	@Bean(name="viewResolver")
//	public ViewResolver initViewResolver() {
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setSuffix(".jsp");
//		resolver.setPrefix("/WEB-INF/page/");
//		return resolver;
//	}
//	
//}
