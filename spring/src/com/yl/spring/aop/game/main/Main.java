package com.yl.spring.aop.game.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.yl.spring.aop.game.Interceptor;
import com.yl.spring.aop.game.ProxyBeanFactory;
import com.yl.spring.aop.game.interceptor.RoleInterceptor;
import com.yl.spring.aop.game.service.RoleService;
import com.yl.spring.aop.game.service.impl.RoleServiceImpl;
import com.yl.spring.pojo.Role;

public class Main {


	public static void main(String[] args) {
		RoleService roleService = new RoleServiceImpl();
		Interceptor interceptor = new RoleInterceptor();
		Role role = new Role();
		role.setId(1l);
		role.setRoleName("role_name_1");
		role.setNote("note_1");
		RoleService roleServiceProxy = ProxyBeanFactory.getBean(roleService, interceptor);
		roleServiceProxy.printRole(null);
//		Calendar c = Calendar.getInstance();
//		String dateStr = "20190301";
//		try {
//			c.setTime(new SimpleDateFormat("yyyyMMdd").parse(dateStr));
//			c.add(Calendar.DAY_OF_YEAR, 127);
//			System.out.println(new SimpleDateFormat("yyyyMMdd").format(c.getTime()));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
	}
}

