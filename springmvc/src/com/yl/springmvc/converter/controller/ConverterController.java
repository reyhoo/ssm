package com.yl.springmvc.converter.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.yl.springmvc.params.service.RoleService;
import com.yl.springmvc.pojo.Role;

@Controller
@RequestMapping("converter")
public class ConverterController {

	@Autowired
	private RoleService roleService;
	
	
	@ResponseBody
	@RequestMapping("getRoleJson")
	public Object getRoleJson(Long id) {
//		RequestMappingHandlerAdapter adapter = null;
//		adapter.setMessageConverters(messageConverters);
//		MappingJackson2HttpMessageConverter c = null;
//		c.setSupportedMediaTypes(supportedMediaTypes);
//		MappingJackson2XmlHttpMessageConverter c = null;
//		c.setSupportedMediaTypes(supportedMediaTypes);
		Role role = roleService.getRole(id);
//		return role;
		Map<String, Object> map = new HashMap<>();
		map.put("id", role.getId());
		map.put("roleName", role.getRoleName());
		return map;
	}
}
