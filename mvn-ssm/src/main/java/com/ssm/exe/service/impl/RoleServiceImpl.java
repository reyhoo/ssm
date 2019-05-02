package com.ssm.exe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.exe.mapper.RoleMapper;
import com.ssm.exe.pojo.Role;
import com.ssm.exe.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	@Override
	public Role getRole(Long id) {
		return roleMapper.getRole(id);
	}

}
