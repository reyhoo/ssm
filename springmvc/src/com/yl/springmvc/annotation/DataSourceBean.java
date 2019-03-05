//package com.yl.springmvc.annotation;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.apache.commons.dbcp.BasicDataSourceFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataSourceBean {
//
//	@Value("${database.url}")
//	private String url;
//	@Value("${database.username}")
//	private String username;
//	@Value("${database.password}")
//	private String password;
//	@Value("${database.driver}")
//	private String driver;
//	
//	@Bean(name="dataSource")
//	public DataSource initDataSource() {
//		Properties prop = new Properties();
//		prop.setProperty("url", url);
//		prop.setProperty("username", username);
//		prop.setProperty("password", password);
//		prop.setProperty("driver", driver);
//		try {
//			return BasicDataSourceFactory.createDataSource(prop);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	
//}
