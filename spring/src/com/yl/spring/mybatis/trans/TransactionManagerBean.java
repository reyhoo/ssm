package com.yl.spring.mybatis.trans;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Component
public class TransactionManagerBean implements TransactionManagementConfigurer{

	
//	@Value("#{dataSource}")
	@Autowired
	private DataSource dataSource;
	
	
	@Override
	@Bean(name="transactionManager")
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource);
		return transactionManager;
	}
}
