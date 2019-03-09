package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.mapper.RoleMapper;
import com.ssm.pojo.Role;
import com.ssm.pojo.RoleParams;
import com.ssm.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	@Override
	public int addRole(Role role) {
		return roleMapper.insertRole(role);
	}

	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	@Override
	public int addRoleList(List<Role> roleList) {
		int count = 0;
		for (Role role : roleList) {
			count += roleMapper.insertRole(role);
		}
		return count;
	}

	@Override
	public List<Role> findRoles(RoleParams roleParams) {
		return roleMapper.findRoles(roleParams);
	}

	@Override
	public Role getRole(Long id) {
		return roleMapper.getRole(id);
	}

	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	@Override
	public int deleteRole(Long id) {
		return roleMapper.deleteRole(id);
	}
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	@Override
	public int deleteRoles(List<Long> ids) {
		int count = 0;
		for (Long id : ids) {
			count += roleMapper.deleteRole(id);
		}
		return count;
	}
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	@Override
	public int updateRole(Role role) {
		return roleMapper.updateRole(role);
	}
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	@Override
	public int updateRoleList(List<Role> roleList) {
		int count = 0;
		for (Role role : roleList) {
			count += roleMapper.updateRole(role);
		}
		return count;
	}

}
