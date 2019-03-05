package com.yl.spring.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yl.spring.pojo.Role;

@Repository
public interface RoleMapper {
	
	Role getRole(@Param("id") Long id);
	int insertRole(Role role);
	int deleteRole(@Param("id")Long id);
	int updateRole(Role role);
}
