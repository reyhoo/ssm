package com.yl.spring.aop.service.impl;

import org.springframework.stereotype.Component;

import com.yl.spring.aop.service.RoleService;
import com.yl.spring.pojo.Role;
@Component
public class RoleServiceImpl implements RoleService {

	@Override
	public Role printRole(Role role) {
		System.out.println("{id = "+role.getId() + ", roleName = "+role.getRoleName() + ", note=" + role.getNote() + "} ");
		return role;
	}

}
