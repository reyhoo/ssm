package com.yl.spring.jdbc.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yl.spring.jdbc.JdbcConfig;
import com.yl.spring.jdbc.service.RoleService;
import com.yl.spring.pojo.Role;

public class Main {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(JdbcConfig.class);
		RoleService roleService = cxt.getBean(RoleService.class);
		Role role = new Role();
		role.setRoleName("worker");
		role.setNote("never give up");
		roleService.addRole(role);
		cxt.close();
	}
}
