package com.ssm.exe.mapper;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class Test {

	
	public static void main(String[] args) {
		
		DispatcherServlet servlet = null;
//		servlet.setContextConfigLocation(contextConfigLocation);
//		ContextLoaderListener
//		CharacterEncodingFilter
		InternalResourceViewResolver r = null;
//		r.setPrefix(prefix);
//		r.setSuffix("");
//		BasicDataSource d = null;
//		d.setUsername(username);
//		d.setPassword(password);
//		d.setUrl(url);
//		d.setDriverClassName(driverClassName);
		
//		SqlSessionFactoryBean b = null;
//		b.setConfigLocation(configLocation);
//		b.setDataSource(dataSource);
//		DataSourceTransactionManager
		
//		MapperScannerConfigurer c = null;
//		c.setAnnotationClass(annotationClass);
//		c.setSqlSessionFactoryBeanName(sqlSessionFactoryBeanName);
//		c.setBasePackage(basePackage);
//		@Repository
	}
}
