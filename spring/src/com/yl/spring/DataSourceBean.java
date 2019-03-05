package com.yl.spring;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import com.yl.spring.annotation.condition.DataSourceCondition;
@Component
public class DataSourceBean {
	
	@Value("${database.url}")
	private String url = null;
	@Value("${database.driver}")
	private String driver = null;
	@Value("${database.username}")
	private String username = null;
	@Value("${database.password}")
	private String password = null;
	@Bean(name="dataSource")
	@Conditional(DataSourceCondition.class)
	public DataSource getDataSource() {
		Properties prop = new Properties();
		prop.setProperty("url", url);
		prop.setProperty("driver", driver);
		prop.setProperty("username", username);
		prop.setProperty("password", password);
		try {
			return BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
