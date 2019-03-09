package com.ssm.service;

import java.util.List;

import com.ssm.pojo.Role;
import com.ssm.pojo.RoleParams;

public interface RoleService {

	
	int addRole(Role role);
	
	int addRoleList(List<Role> roleList);
	
	List<Role>findRoles(RoleParams roleParams);
	
	Role getRole(Long id);
	
	int deleteRole(Long id);
	
	int deleteRoles(List<Long>ids);
	
	int updateRole(Role role);
	
	int updateRoleList(List<Role>roleList);
}
