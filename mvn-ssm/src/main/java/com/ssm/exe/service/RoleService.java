package com.ssm.exe.service;

import com.ssm.exe.pojo.Role;

import java.util.List;

public interface RoleService {

	
	Role getRole(Long id);

	List<Role>getAll();

	Role modifyRole(Role role);

	Role addRole(Role role);

	int delete(Long id);
}
