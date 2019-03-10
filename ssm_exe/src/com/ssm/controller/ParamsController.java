package com.ssm.controller;

import java.util.List;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.ssm.pojo.Role;
import com.ssm.pojo.RoleParams;
import com.ssm.service.RoleService;


@Controller
@RequestMapping("params")
public class ParamsController {

	
	
	
	private void test() {
//		
//		ContextLoaderListener listener = null;
//		CharacterEncodingFilter filter  = null;
//		filter.setEncoding(encoding);
//		filter.setForceEncoding(forceEncoding);
//		
//		DispatcherServlet dispatcherServlet = null;
//		dispatcherServlet.setContextConfigLocation(contextConfigLocation);
		
//		PropertySourcesPlaceholderConfigurer configurer = null;
//		configurer.setLocations(locations);
//		SqlSessionFactoryBean sessionFactoryBean = null;
//		sessionFactoryBean.setConfigLocation(configLocation);
		
//		MapperScannerConfigurer c = null;
//		c.setAnnotationClass(annotationClass);
//		c.setBasePackage(basePackage);
//		c.setSqlSessionFactoryBeanName(sqlSessionFactoryBeanName);
//		@Repository
//		DataSourceTransactionManager
		
		
//		InternalResourceViewResolver viewResolver = null;
//		viewResolver.setPrefix(prefix);
//		viewResolver.setSuffix(suffix);
		
//		StandardServletMultipartResolver
		
		
	}
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("addRoleForm")
	public String addRoleForm() {
		return "addRoleForm";
	}
	
	@RequestMapping("addRole1")
	@ResponseBody
	public Role addRole1(String roleName,String note) {
		System.err.println(roleName);
		System.err.println(note);
		Role role = new Role();
		role.setRoleName(roleName);
		role.setNote(note);
		roleService.addRole(role);
		return role;
	}
	
	@RequestMapping("addRole2")
	@ResponseBody
	public Role addRole2(Role role) {
		roleService.addRole(role);
		return role;
	}
	
	@RequestMapping("addRole3")
	@ResponseBody
	public Role addRole3(@RequestParam(value="roleName",required=false)String role_name,String note) {
		System.err.println(role_name);
		System.err.println(note);
		Role role = new Role();
		role.setRoleName(role_name);
		role.setNote(note);
		roleService.addRole(role);
		return role;
	}
	
	@RequestMapping("getRole/{id}")
	@ResponseBody
	public Role getRole(@PathVariable("id") Long id) {
		return roleService.getRole(id);
	}
	@RequestMapping("postJson")
	public String postJson() {
		return "postJson";
	}
	
	@RequestMapping("addRoles")
	@ResponseBody
	public List<Role> addRoles(@RequestBody List<Role>roleList) {
		roleService.addRoleList(roleList);
		return roleList;
	}
	
	
	@RequestMapping("findRoles")
	@ResponseBody
	public List<Role> findRoles(@RequestBody RoleParams roleParams) {
		return roleService.findRoles(roleParams);
	}
	@RequestMapping("deleteRoles")
	@ResponseBody
	public String deleteRoles(@RequestBody List<Long>ids) {
		int count = roleService.deleteRoles(ids);
		return count+"";
	}
	
}
