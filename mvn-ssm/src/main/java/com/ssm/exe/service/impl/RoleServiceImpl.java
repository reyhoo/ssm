package com.ssm.exe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.exe.mapper.RoleMapper;
import com.ssm.exe.pojo.Role;
import com.ssm.exe.service.RoleService;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	@Override
	@Cacheable(value = "redisCacheManager",key = "'redis_role_'+#id")
	public Role getRole(Long id) {
		return roleMapper.getRole(id);
	}

	@Override
	public List<Role> getAll() {
		return roleMapper.getAll();
	}

	@Transactional
	@CachePut(value = "redisCacheManager",key = "'redis_role_'+#role.id")
	@Override
	public Role modifyRole(Role role) {
		roleMapper.updateRole(role);
		return role;
	}
	@Transactional
	@CachePut(value = "redisCacheManager",key = "'redis_role_'+#result.id")
	@Override
	public Role addRole(Role role) {
		roleMapper.insertRole(role);
		System.err.println(role.getId());
		System.err.println(role.getRoleName());
		System.err.println(role.getNote());
		return role;
	}
	@Transactional
	@CacheEvict(value = "redisCacheManager",key = "'redis_role_'+#id")
	@Override
	public int delete(Long id) {
		return roleMapper.delete(id);
	}

}
