package com.yl.spring.mybatis.trans.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yl.spring.mybatis.trans.mapper.RoleMapper;
import com.yl.spring.mybatis.trans.pojo.Role;
import com.yl.spring.mybatis.trans.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleMapper roleMapper;
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public int insertRole(Role role) {
		return roleMapper.insertRole(role);
	}

}
