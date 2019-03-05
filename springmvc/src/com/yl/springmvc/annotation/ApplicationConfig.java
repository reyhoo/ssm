//package com.yl.springmvc.annotation;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.springframework.context.annotation.ImportResource;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//
//import com.yl.springmvc.App;
//
//@ComponentScan(basePackageClasses=App.class)
//@EnableAspectJAutoProxy
//@PropertySource("/WEB-INF/config/db.properties")
//@ImportResource("/WEB-INF/config/spring-mybatis.xml")
//
//public class ApplicationConfig {
//
//		@Bean
//		public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//			return new PropertySourcesPlaceholderConfigurer();
//		}
//
//
//}
