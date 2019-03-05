package com.yl.spring.mybatis.trans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan(basePackageClasses=ApplicationConfig.class)
@Configuration
@ImportResource("classpath:/com/yl/spring/mybatis/trans/spring-mybatis-trans.xml")
@PropertySource({"classpath:jdbc.properties"})
//使用事务驱动管理器
@EnableTransactionManagement   //<tx:annotation-driven transaction-manager="transactionManager"/> 这两个效果是一样的

public class ApplicationConfig {

	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return  new PropertySourcesPlaceholderConfigurer();
	}
	
	
}
