//package com.yl.springmvc.annotation;
//
//import javax.sql.DataSource;
//
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.mapper.MapperScannerConfigurer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.io.PathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//
//@Component
//public class MyBatisBean {
//
//	@Value("#{dataSource}")
//	private DataSource dataSource;
//	
//	@Bean(name="sqlSessionFactory")
//	public SqlSessionFactoryBean initSqlSessionFactory() {
//		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//		Resource resource = new PathResource("/WEB-INF/mybatis-config.xml");
//		sqlSessionFactoryBean.setConfigLocation(resource);
//		sqlSessionFactoryBean.setDataSource(dataSource);
//		return sqlSessionFactoryBean;
//	}
//	@Bean
//	public MapperScannerConfigurer initMapperScannerConfigurer() {
//		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
//		mapperScannerConfigurer.setAnnotationClass(Repository.class);
//		mapperScannerConfigurer.setBasePackage("com.**");
//		return mapperScannerConfigurer;
//	}
//}
