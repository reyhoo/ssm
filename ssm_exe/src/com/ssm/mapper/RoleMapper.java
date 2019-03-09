package com.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ssm.pojo.Role;
import com.ssm.pojo.RoleParams;
@Repository
public interface RoleMapper {


	int insertRole(Role role);
	
	List<Role>findRoles(RoleParams roleParams);
	
	Role getRole(@Param("id")Long id);
	
	int deleteRole(@Param("id")Long id);
	
	int updateRole(Role role);
	
}
