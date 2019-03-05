package com.yl.spring.aop.xml.service.impl;

import com.yl.spring.aop.xml.service.RoleService;
import com.yl.spring.pojo.Role;

public class RoleServiceImpl implements RoleService {

	@Override
	public void printRole(Role role) {
		System.out.println("{id = "+role.getId() + ", roleName = "+role.getRoleName() + ", note=" + role.getNote() + "} ");
	}

}
