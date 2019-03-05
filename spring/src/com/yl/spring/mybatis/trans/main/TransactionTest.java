package com.yl.spring.mybatis.trans.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yl.spring.mybatis.trans.ApplicationConfig;
import com.yl.spring.mybatis.trans.pojo.Role;
import com.yl.spring.mybatis.trans.service.RoleListService;

public class TransactionTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RoleListService roleListService = cxt.getBean(RoleListService.class);
		List<Role>list = new ArrayList<>();
		Role role = new Role();
		role.setRoleName("role_name_trans_1");
		role.setNote("note_trans_1");
		list.add(role);
		role = new Role();
		role.setRoleName("role_name_trans_2");
		role.setNote("note_trans_2");
		list.add(role);
		int count = roleListService.insertRoleList(list);
		System.out.println(count);
		cxt.close();
		
	}
}
