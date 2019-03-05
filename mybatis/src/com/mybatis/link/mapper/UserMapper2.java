package com.mybatis.link.mapper;

import java.util.List;

import com.mybatis.link.pojo.User2;

public interface UserMapper2 {

	public User2 getUser(Long id);
	
	public List<User2>findUsersByRoleId(Long roleId);
}
