package com.ssm.exe.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.ssm.exe.pojo.Role;

import java.util.List;

@Repository
public interface RoleMapper {

	
	Role getRole(Long id);

	List<Role>getAll();


	int updateRole(@Param("role") Role role);

	int insertRole(@Param("role") Role role);

	@Delete("delete from t_role where id = #{id}")
	int delete(@Param("id") long id);
}
