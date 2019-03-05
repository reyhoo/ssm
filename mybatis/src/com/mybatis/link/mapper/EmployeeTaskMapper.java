package com.mybatis.link.mapper;

import java.util.List;

import com.mybatis.link.pojo.EmployeeTask;

public interface EmployeeTaskMapper {

	
	List<EmployeeTask> getEmployeeTaskByEmpId(Long id);
	
	EmployeeTask getById(Long id);
}
