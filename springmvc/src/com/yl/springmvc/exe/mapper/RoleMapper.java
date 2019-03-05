package com.yl.springmvc.exe.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yl.springmvc.pojo.Role;
@Repository("RoleMapper1")
public interface RoleMapper {

	
	Role getRole(@Param("id")Long id);
}
