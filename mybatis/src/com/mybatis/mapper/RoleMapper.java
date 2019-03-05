package com.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.mybatis.pojo.PageParam;
import com.mybatis.pojo.Role;

public interface RoleMapper {

	
	Role getRole(Long id);
	int insertRole(Role role);
	int updateRole(Role role);
	int deleteRole(Long id);
	
	
	//传递多个参数
	/**
	 * 使用map接口传递参数
	 * @param map
	 * @return
	 */
	List<Role>findRolesByMap(Map<String, Object> map);
	
	/**
	 * 使用注解传递多个参数
	 * @param rolename
	 * @param note
	 * @return
	 */
	List<Role>findRolesByAnnotation(@Param("roleName1") String rolename,@Param("note1")String note);
	/**
	 *混合使用注解传递和Javabean传递(分页查询)
	 * @param rolename
	 * @param note
	 * @param pageParam
	 * @return
	 */
	List<Role>findRolesByMix(@Param("roleName") String rolename,@Param("note")String note,@Param("page")PageParam pageParam);
	/**
	 * 使用RowBounds进行分页查询（在方法传入即可，不用在sql加分页）
	 * @param rolename
	 * @param note
	 * @param rowBounds
	 * @return
	 */
	List<Role> findRolesByRowBounds(@Param("roleName") String rolename,@Param("note")String note,RowBounds rowBounds);

	/**
	 * 主键回填
	 * @param role
	 * @return
	 */
	int insertRoleGetId(Role role);//TODO
	/**
	 * 使用自定义id
	 * @param role
	 * @return
	 */
	int insertRoleCustomId(Role role);//TODO
}
