package com.ssm.exe.mapper;

import org.springframework.stereotype.Repository;

import com.ssm.exe.pojo.Role;

@Repository
public interface RoleMapper {

	
	Role getRole(Long id);
}
