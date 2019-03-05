package com.yl.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@ComponentScan(basePackageClasses= {ApplicationConfig.class})
//@ImportResource({"classpath:datasource.xml"})//使用xml装配dataSource
@PropertySource("classpath:jdbc.properties")//导入properties
public class ApplicationConfig {

	//为了让spring能够解析属性占位符，需要装备下面的类
	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}

	
}
