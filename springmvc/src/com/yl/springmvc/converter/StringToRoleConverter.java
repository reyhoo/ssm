package com.yl.springmvc.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.yl.springmvc.pojo.Role;

public class StringToRoleConverter implements Converter<String, Role> {

	/**
	 * 1-role_name1-note1
	 */
	@Override
	public Role convert(String str) {
		if(StringUtils.isEmpty(str)) {
			return null;
		}
		if(str.indexOf("-") == -1) {
			return null;
		}
		String[] arr = str.split("\\-");
		if(arr.length != 3) {
			return null;
		}
		Role role = new Role();
		role.setId(Long.parseLong(arr[0]));
		role.setRoleName(arr[1]);
		role.setNote(arr[2]);
		return role;
	}

}
