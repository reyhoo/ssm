package com.yl.springmvc.params.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yl.springmvc.pojo.Role;
import com.yl.springmvc.pojo.RoleParams;
@Repository
public interface RoleMapper {

	
	Role getRole(@Param("id")Long id);
	
	List<Role> findRoles(RoleParams roleParams);
	
	int deleteRoles(@Param("ids")List<Long> ids);
	
	int insertRole(Role role);
}
