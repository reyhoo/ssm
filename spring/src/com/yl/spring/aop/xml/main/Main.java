package com.yl.spring.aop.xml.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yl.spring.aop.xml.service.RoleService;
import com.yl.spring.pojo.Role;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("aop-xml.xml");
		RoleService roleService = cxt.getBean(RoleService.class);
		Role role = new Role();
		role.setId(10l);
		role.setRoleName("role_name_10");
		role.setNote("note_10");
		roleService.printRole(role);
		cxt.close();
	}
}
