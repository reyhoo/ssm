package com.mybatis.utils;

import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtils {

	private static final Class<SqlSessionFactoryUtils> LOCK = SqlSessionFactoryUtils.class;
	
	private static SqlSessionFactory sqlSessionFactory = null;
	
	public static SqlSessionFactory getSqlSessionFactory() {
		if(sqlSessionFactory == null) {
			synchronized (LOCK) {
				if(sqlSessionFactory == null) {
					Properties prop =  new Properties();
					prop.put("database.driver", "com.mysql.jdbc.Driver");
					prop.put("database.url", "jdbc:mysql://192.168.1.108:3306/ssm?useUnicode=true&characterEncoding=utf8");
					prop.put("database.username", "root");
					prop.put("database.password", "");
					sqlSessionFactory = new SqlSessionFactoryBuilder().build(SqlSessionFactoryUtils.class.getResourceAsStream("/mybatis-config.xml"),prop);
				}
			}
		}
		return sqlSessionFactory;
		
	}
	
	public static SqlSession openSqlSession() {
		return getSqlSessionFactory().openSession();
	}
}
