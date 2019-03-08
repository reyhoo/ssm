package com.yl.springmvc.params.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yl.springmvc.params.mapper.RoleMapper;
import com.yl.springmvc.params.service.RoleService;
import com.yl.springmvc.pojo.Role;
import com.yl.springmvc.pojo.RoleParams;

@Service("RoleServiceImpl2")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	@Override
	public Role getRole(Long id) {
		return roleMapper.getRole(id);
	}
	@Override
	public List<Role> findRoles(RoleParams roleParams) {
		return roleMapper.findRoles(roleParams);
	}
	@Override
	@Transactional
	public int deleteRoles(List<Long> ids) {
		return roleMapper.deleteRoles(ids);
	}
	@Override
	@Transactional
	public int addRoles(List<Role> roles) {
		int count = 0;
		for (Role role : roles) {
			count+=roleMapper.insertRole(role);
		}
//		String line = null;line.length();
		return count;
	}
	@Override
	@Transactional
	public int addRole(Role role) {
		return roleMapper.insertRole(role);
	}
	@Transactional
	@Override
	public int updateRole(Role role) {
		return roleMapper.updateRole(role);
	}
	
	@Transactional
	@Override
	public int updateRoles(List<Role> roles) {
		int count = 0;
		for (Role role : roles) {
			count+=roleMapper.updateRole(role);
		}
		return count;
	}

}
