package com.mybatis.dynamicsql.mapper;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mybatis.pojo.Role;

public interface RoleMapper {
	/**
	 * 使用if元素
	 * @param roleName
	 * @return
	 */
	List<Role> findRoles(@Param("roleName") String roleName);

	/**
	 * 使用choose,when,otherwise元素
	 * @param role
	 * @return
	 */
	List<Role> findRoles2(Role role);
	
	/**
	 * 使用where元素
	 * @param role
	 * @return
	 */
	List<Role> findRoles3(Role role);
	
	/**
	 * 使用trim用作where
	 * @param role
	 * @return
	 */
	List<Role> findRoles4(@Param("role")Role role);
	
	/**
	 * 使用set元素
	 * @param role
	 * @return
	 */
	int updateRole(Role role);
	/**
	 * 使用trim用作set
	 * @param role
	 * @return
	 */
	int updateRole2(Role role);
	/**
	 * 使用foreach元素
	 * @param ids
	 * @return
	 */
	List<Role>findRolesByIds(@Param("ids") Long...ids);
	/**
	 * 使用bind元素设置变量
	 * @param rolename
	 * @param note
	 * @return
	 */
	List<Role> findRoles5(@Param("roleName")String rolename,@Param("note")String note);
}
