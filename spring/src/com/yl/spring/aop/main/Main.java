package com.yl.spring.aop.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yl.spring.aop.AopConfig;
import com.yl.spring.aop.service.RoleService;
import com.yl.spring.aop.verifier.RoleVerifier;
import com.yl.spring.pojo.Role;

public class Main {

	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(AopConfig.class);
//		ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("aop-aspect.xml");
		RoleService roleService = cxt.getBean(RoleService.class);
//		RoleVerifier roleVerifier = (RoleVerifier) roleService;
		Role role = new Role();
		role.setId(1l);
		role.setRoleName("role_name_1");
		role.setNote("note_1");
//		if(roleVerifier.verify(role)) {
			role = roleService.printRole(role);
//		}
		cxt.close();
	}
}
