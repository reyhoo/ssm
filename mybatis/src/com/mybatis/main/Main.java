package com.mybatis.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.mybatis.mapper.RoleMapper;
import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.PageParam;
import com.mybatis.pojo.Role;
import com.mybatis.pojo.SexEnum;
import com.mybatis.pojo.User;
import com.mybatis.utils.SqlSessionFactoryUtils;


public class Main {

	public static void main(String[] args) {
		testRole();
//		testUser();
	}

	private static void testUser() {
		SqlSession session = SqlSessionFactoryUtils.openSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		List<User> list = userMapper.getAllUser();
		User u = userMapper.getUser(1l);
		Logger logger = Logger.getLogger(Main.class);
		logger.error(list.toString());
		logger.error(u.toString());
		
//		User user = new User();
//		user.setEmail("15129237121@163.com");
//		user.setMobile("15129237121");
//		user.setTel("15129237121");
//		user.setNote("姚磊note");
//		user.setPassword("111111");
//		user.setSex(SexEnum.MALE);
//		user.setUserName("姚磊");
//		userMapper.insertUser(user);
//		user = new User();
//		user.setEmail("130@163.com");
//		user.setMobile("130");
//		user.setTel("130t");
//		user.setNote("魏碧云note");
//		user.setPassword("222222");
//		user.setSex(SexEnum.FEMALE);
//		user.setUserName("魏碧云");
//		userMapper.insertUser(user);
//		session.commit();
		session.close();
	}
	private static void testRole() {
		Logger logger = Logger.getLogger(Main.class);
		SqlSession sqlsession =null;
		try {
			sqlsession	= SqlSessionFactoryUtils.openSqlSession();
			RoleMapper mapper = sqlsession.getMapper(RoleMapper.class);
//			for (int i = 0; i < 50; i++) {
//				Role role = new Role();
//				role.setNote( "备注"+(i+1));
//				role.setRoleName("角色名称"+(i+1));
//				mapper.insertRole(role);
//			}
//		
//			sqlsession.commit();
//			Role role = mapper.getRole(2l);
//			logger.info(role.getRoleName());
			Map<String, Object>map = new HashMap<>();
			map.put("roleName", "role_name");
			map.put("note", "note");
			List<Role> list = mapper.findRolesByMap(map);
			logger.info(list);
//			List<Role> list = mapper.findRolesByAnnotation("role_name", "note");
//			logger.info(list);
//			PageParam pageParam = new PageParam();
//			pageParam.setStart(5);
//			pageParam.setLimit(4);
//			List<Role> list = mapper.findRolesByMix("role_name", "note",pageParam);
//			logger.info(list);
//			RowBounds rowBounds = new RowBounds(0,30);
//			List<Role> list = mapper.findRolesByRowBounds("名称", "备注", rowBounds);
//			logger.info(list.size());
			
//			Role role = new Role();
//			role.setNote("work work work");
//			role.setRoleName("worker");
//			mapper.insertRoleGetId(role);
//			sqlsession.commit();
//			Role role = new Role();
//			role.setNote("work work work3");
//			role.setRoleName("worker3");
//			mapper.insertRoleCustomId(role);
//			sqlsession.commit();
			//测试使用自定义ID插入的并发问题
//			for (int i = 0; i < 100; i++) {
//				insertInThread(i+1);
//			}
			
		}finally {
			if(sqlsession != null) {
				sqlsession.close();
			}
		}
	}

	private static void insertInThread(final int i) {
		new Thread() {
			public void run() {
				synchronized (Main.class) {
					SqlSession sqlsession =null;
					try {
						sqlsession	= SqlSessionFactoryUtils.openSqlSession();
						RoleMapper mapper = sqlsession.getMapper(RoleMapper.class);
						Role role = new Role();
						role.setNote("note"+i);
						role.setRoleName("role_name"+i);
						mapper.insertRoleCustomId(role);
						sqlsession.commit();
					} finally {
						if(sqlsession != null) {
							sqlsession.close();
						}
					}
				}
				
			}; 
		}.start();
	}
}
