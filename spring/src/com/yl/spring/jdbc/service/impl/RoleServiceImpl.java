package com.yl.spring.jdbc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yl.spring.jdbc.dao.RoleDao;
import com.yl.spring.jdbc.service.RoleService;
import com.yl.spring.pojo.Role;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public int addRole(Role role) {
		int i = roleDao.insertRole(role);
		return i;
	}

}
