package com.yl.springmvc.params.service;

import java.util.List;

import com.yl.springmvc.pojo.Role;
import com.yl.springmvc.pojo.RoleParams;

public interface RoleService {

	Role getRole(Long id);
	
	List<Role>findRoles(RoleParams roleParams);
	
	int deleteRoles(List<Long>ids);
	
	int addRoles(List<Role>roles);
	
	int addRole(Role role);
}
