package com.yl.springmvc.exe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yl.springmvc.exe.mapper.RoleMapper;
import com.yl.springmvc.exe.service.RoleService;
import com.yl.springmvc.pojo.Role;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Role getRole(Long id) {
		return roleMapper.getRole(id);
	}

}
