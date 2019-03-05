package com.yl.spring.aop.game.service.impl;

import org.springframework.stereotype.Component;

import com.yl.spring.aop.game.service.RoleService;
import com.yl.spring.pojo.Role;

public class RoleServiceImpl implements RoleService {

	@Override
	public void printRole(Role role) {
		System.out.println("{id = "+role.getId() + ", roleName = "+role.getRoleName() + ", note=" + role.getNote() + "} ");
	}

}
