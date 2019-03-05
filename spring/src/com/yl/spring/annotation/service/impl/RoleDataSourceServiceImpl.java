package com.yl.spring.annotation.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.yl.spring.annotation.service.RoleDataSourceService;
import com.yl.spring.pojo.Role;

@Component
public class RoleDataSourceServiceImpl implements RoleDataSourceService {

//	@Autowired
//	@Qualifier("dataSource")
	
//	@Resource(name = "dataSource")
	@Value("#{dataSource}")
	private DataSource dataSource;

	@Override
	public Role getRole(Long id) {
		Connection conn = null;
		PreparedStatement ps = null;
		Role role = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement("select id,role_name,note from t_role where id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				role = new Role();
				role.setId(rs.getLong("id"));
				role.setRoleName(rs.getString("role_name"));
				role.setNote(rs.getString("note"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return role;
	}

}
