package com.yl.spring.mybatis;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ComponentScan(basePackageClasses=AppConfig.class)
@ImportResource("classpath:spring-mybatis.xml")
public class AppConfig {

	private void test() {
		BasicDataSource basicDataSource = null;
//		basicDataSource.setUsername(username);
//		basicDataSource.setDriverClassName(driverClassName);
		SqlSessionFactoryBean bean = null;
//		bean.setConfigLocation(configLocation);
//		bean.setDataSource(dataSource);
		
		MapperScannerConfigurer configurer = null;
//		configurer.setAnnotationClass(annotationClass);
//		configurer.setBasePackage(basePackage);
//		configurer.setSqlSessionFactoryBeanName(sqlSessionFactoryName);
	}
}
