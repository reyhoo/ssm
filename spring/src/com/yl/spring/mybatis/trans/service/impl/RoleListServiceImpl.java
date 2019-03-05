package com.yl.spring.mybatis.trans.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yl.spring.mybatis.trans.mapper.RoleMapper;
import com.yl.spring.mybatis.trans.pojo.Role;
import com.yl.spring.mybatis.trans.service.RoleListService;
import com.yl.spring.mybatis.trans.service.RoleService;

@Service
public class RoleListServiceImpl implements RoleListService {

	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RoleService roleService;
	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public int insertRoleList(List<Role> roleList) {
		int count = 0;
		for(Role role:roleList) {
			try {
				count += roleMapper.insertRole(role);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String line = null;
//		line.length();
		return count;
	}

}
