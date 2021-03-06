package com.yl.springmvc.converter.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yl.springmvc.converter.pojo.FormatPojo;
import com.yl.springmvc.params.service.RoleService;
import com.yl.springmvc.pojo.Role;

@Controller
@RequestMapping("converter")
public class ConverterController {

	@Autowired
	private RoleService roleService;
	/**
	 * 测试HttpMessageConverter和JSON消息转换器
	 * ids=1,2,3
	 * @param ids
	 * @return
	 */
	
	@ResponseBody
	@RequestMapping("getRoleJson")
	public Object getRoleJson(Long[] ids) {
//		RequestMappingHandlerAdapter adapter = null;
//		adapter.setMessageConverters(messageConverters);
//		MappingJackson2HttpMessageConverter c = null;
//		c.setSupportedMediaTypes(supportedMediaTypes);
//		MappingJackson2XmlHttpMessageConverter c = null;
//		c.setSupportedMediaTypes(supportedMediaTypes);
		
//		FormattingConversionServiceFactoryBean
		System.err.println(Arrays.toString(ids));
		Role role = roleService.getRole(ids[0]);
		return role;
//		Map<String, Object> map = new HashMap<>();
//		map.put("id", role.getId());
//		map.put("roleName", role.getRoleName());
//		return map;
	}
	/**
	 * role=21-rolename21-note21
	 * 测试一对一转换器
	 * @param role
	 * @return
	 */
	@RequestMapping("updateRole")
	@ResponseBody
	public Map<String,String> updateRole(Role role) {
		int count = roleService.updateRole(role);
		Map<String, String>map = new HashMap<>();
		map.put("updateTotal", ""+count);
		return map;
	}
	/**
	 * 测试失败，原因不明
	 * roles=role=21-rolename21-note21,22-rolename22-note22
	 * @param roles
	 * @return
	 */
	@RequestMapping("updateRoleList")
	@ResponseBody
	public Map<String,String> updateRoleList(@RequestParam("roles")List<Role> roles) {
		int count = roleService.updateRoles(roles);
		Map<String, String>map = new HashMap<>();
		map.put("updateTotal", ""+count);
		return map;
	}
	/**
	 * http://localhost/springmvc/converter/format?date=1989-03-25&amount=1111999.99
	 * 使用注解@DateTimeFormat和@NumberFormat格式化数据
	 * @param date
	 * @param amount
	 * @return
	 */
	@RequestMapping("format")
	@ResponseBody
	public Map<String, String>format(@DateTimeFormat(iso=ISO.DATE)Date date,
			@NumberFormat(pattern="#,###.##")Double amount){
		Map<String, String> map = new HashMap<>();
		map.put("date", date+"");
		map.put("amount", amount+"");
		return map;
	}
	@RequestMapping("formatPojo")
	@ResponseBody
	public Map<String, String> formatPojo(FormatPojo formatPojo){
		Map<String, String> map = new HashMap<>();
		map.put("date1", formatPojo.getDate1()+"");
		map.put("amount1", formatPojo.getAmount1().doubleValue()+"");
		return map;
	}
}
