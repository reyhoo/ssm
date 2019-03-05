package com.yl.spring.jdbc.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.yl.spring.jdbc.dao.RoleDao;
import com.yl.spring.pojo.Role;

@Component
public class RoleDaoImpl extends JdbcTemplate implements RoleDao{

	
	
	@Override
	@Value("#{dataSource}")
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public int insertRole(Role role) {
		return this.update("insert into t_role (role_name,note) values (?,?)", role.getRoleName(),role.getNote());
	}

}
