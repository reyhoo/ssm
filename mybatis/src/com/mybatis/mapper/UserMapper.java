package com.mybatis.mapper;

import java.util.List;

import com.mybatis.pojo.User;

public interface UserMapper {

	
	int insertUser(User user);
	
	User getUser(Long id);
	
	List<User> getAllUser();
}
