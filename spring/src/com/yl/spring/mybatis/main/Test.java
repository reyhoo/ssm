package com.yl.spring.mybatis.main;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yl.spring.mybatis.AppConfig;
import com.yl.spring.mybatis.mapper.RoleMapper;
import com.yl.spring.pojo.Role;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(AppConfig.class);
		RoleMapper roleMapper = cxt.getBean(RoleMapper.class);
		Role role = new Role();
		role.setRoleName("role_name_springmybatis");
		role.setNote("note_springmybatis");
		roleMapper.insertRole(role);
		long id = role.getId();
		roleMapper.getRole(id);
		role.setNote("note_springmybatis_update");
		role.setRoleName("");
		roleMapper.updateRole(role);
		roleMapper.deleteRole(id);
		cxt.close();
		
	}
}
