package com.yl.spring.jdbc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ComponentScan(basePackageClasses=JdbcConfig.class)
@ImportResource("classpath:jdbc-datasource.xml")
public class JdbcConfig {

	
}
