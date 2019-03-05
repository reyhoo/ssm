package com.mybatis.link.mapper;

import com.mybatis.link.pojo.Employee;

public interface EmployeeMapper {

	/**
	 * 级联级联查询
	 * @param id
	 * @return
	 */
	Employee getById(Long id);
	
	/**
	 * 使用表连接进行级联查询
	 * @param id
	 * @return
	 */
	Employee getEmployee2(Long id);
}
