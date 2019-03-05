package com.mybatis.link.mapper;

import com.mybatis.link.pojo.WorkCard;

public interface WorkCardMapper {

	WorkCard getByEmpId(Long id);
	WorkCard getById(Long id);
}
