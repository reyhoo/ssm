package com.mybatis.link.mapper;

import java.util.List;

import com.mybatis.link.pojo.Role2;

public interface RoleMapper2 {

	
	Role2 getRole(Long id);
	
	List<Role2>findRolesByUserId(Long userId);
}
