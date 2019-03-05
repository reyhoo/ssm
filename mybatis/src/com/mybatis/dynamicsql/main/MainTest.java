package com.mybatis.dynamicsql.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.dynamicsql.mapper.RoleMapper;
import com.mybatis.pojo.Role;
import com.mybatis.utils.SqlSessionFactoryUtils;

public class MainTest {

	
	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
//			sqlSession = SqlSessionFactoryUtils.openSqlSession();
//			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
//			List<Role> list = roleMapper.findRoles("name1");
//			System.err.println(list);
			
//			sqlSession = SqlSessionFactoryUtils.openSqlSession();
//			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
//			Role roleParams = new Role();
////			roleParams.setId(1l);
//			roleParams.setRoleName("3");
//			List<Role> list = roleMapper.findRoles2(roleParams);
//			System.err.println(list);
			
//			sqlSession = SqlSessionFactoryUtils.openSqlSession();
//			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
//			Role roleParams = new Role();
////			roleParams.setRoleName("3");
////			roleParams.setNote("1");
//			List<Role> list = roleMapper.findRoles3(roleParams);
//			System.err.println(list);
			
			
//			sqlSession = SqlSessionFactoryUtils.openSqlSession();
//			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
//			Role roleParams = new Role();
//			roleParams.setRoleName("3");
////			roleParams.setNote("1");
//			List<Role> list = roleMapper.findRoles4(roleParams);
//			System.err.println(list);
			
			
//			sqlSession = SqlSessionFactoryUtils.openSqlSession();
//			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
//			Role role = new Role();
//			role.setId(3l);
////			role.setRoleName("r22222");
//			role.setNote("n3333");
//			roleMapper.updateRole(role);
//			sqlSession.commit();
			
			
//			sqlSession = SqlSessionFactoryUtils.openSqlSession();
//			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
//			Role role = new Role();
//			role.setId(3l);
////			role.setRoleName("r2222");
//			role.setNote("n3333");
//			roleMapper.updateRole2(role);
//			sqlSession.commit();
			
			
//			sqlSession = SqlSessionFactoryUtils.openSqlSession();
//			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
//			List<Role> list = roleMapper.findRolesByIds(5l,3l);
//			System.out.println(list);
			
			
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			Role roleParams = new Role();
			roleParams.setRoleName("3");
//			roleParams.setNote("1");
			List<Role> list = roleMapper.findRoles5("1","2");
			System.err.println(list);
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
