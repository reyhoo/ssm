package com.mybatis.link.main;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.mybatis.link.mapper.EmployeeMapper;
import com.mybatis.link.mapper.FemaleHealthFormMapper;
import com.mybatis.link.mapper.MaleHealthFormMapper;
import com.mybatis.link.mapper.RoleMapper2;
import com.mybatis.link.mapper.UserMapper2;
import com.mybatis.link.pojo.Employee;
import com.mybatis.link.pojo.FemaleHealthForm;
import com.mybatis.link.pojo.MaleHealthForm;
import com.mybatis.link.pojo.Role2;
import com.mybatis.link.pojo.User2;
import com.mybatis.utils.SqlSessionFactoryUtils;

public class Maintest {

	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Maintest.class);
		SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
//		TaskMapper taskMapper = sqlSession.getMapper(TaskMapper.class);
//		Task task = taskMapper.getTaskById(2l);
//		logger.info(task);
//		WorkCardMapper workCardMapper = sqlSession.getMapper(WorkCardMapper.class);
//		WorkCard workcard = workCardMapper.getByEmpId(5l);
//		logger.info(workcard);
//		
//		EmployeeTaskMapper employeeTaskMapper = sqlSession.getMapper(EmployeeTaskMapper.class);
//		List<EmployeeTask> employeeTaskList = employeeTaskMapper.getEmployeeTaskByEmpId(5l);
//		logger.info(employeeTaskList);
		
//		FemaleHealthFormMapper femaleHealthFormMapper = sqlSession.getMapper(FemaleHealthFormMapper.class);
//		FemaleHealthForm femaleHealthForm = femaleHealthFormMapper.getFemaleHealthForm(4l);
//		logger.info(femaleHealthForm);
//		
//		MaleHealthFormMapper maleHealthFormMapper = sqlSession.getMapper(MaleHealthFormMapper.class);
//		MaleHealthForm maleHealthForm = maleHealthFormMapper.getMaleHealthForm(1l);
//		logger.info(maleHealthForm);
//		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
//		Employee employee = employeeMapper.getById(5l);
//		logger.info(employee.getBirthday());
		
//		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
//		Employee employee = employeeMapper.getEmployee2(6l);
//		logger.info(employee.getBirthday());
		
		UserMapper2 userMapper2 = sqlSession.getMapper(UserMapper2.class);
		User2 user = userMapper2.getUser(3l);
		user.getRoleList();
		logger.info(user);
		
//		RoleMapper2 roleMapper2 = sqlSession.getMapper(RoleMapper2.class);
//		Role2 role = roleMapper2.getRole(6l);
//		role.getUserList();
//		logger.info(role);
	}
}
