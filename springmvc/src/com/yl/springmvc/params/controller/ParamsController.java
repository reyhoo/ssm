package com.yl.springmvc.params.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.alibaba.fastjson.JSON;
import com.yl.springmvc.params.service.RoleService;
import com.yl.springmvc.pojo.Role;
import com.yl.springmvc.pojo.RoleParams;
/**
 * 接收请求参数
 * @author wby
 *
 */
@Controller
@RequestMapping("params")
public class ParamsController {
	
	
	
	@Autowired
	private RoleService roleService;
	
	
	/**
	 * 先访问/page/addRole
	 * 使用方法参数名获取requestParam
	 * @param roleName
	 * @param note
	 * @return
	 */
	@RequestMapping("commonParams")
	public ModelAndView commonParams(String roleName,String note) {
		System.out.println("roleName->"+roleName);
		System.out.println("note->"+note);
		ModelAndView mv = new ModelAndView();
		Role role  = new Role();
		role.setRoleName(roleName);
		role.setNote(note);
		mv.addObject(role);
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}
	
	/**
	 * 先访问/page/addRole
	 * 使用对象获取requestParam
	 * @param role
	 * @return
	 */
	@RequestMapping("commonParamsPojo")
	public ModelAndView commonParams(Role role) {
		ModelAndView mv = new ModelAndView();
		System.out.println("roleName->"+role.getRoleName());
		System.out.println("note->"+role.getNote());
		mv.addObject(role);
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}
	
	
	/**
	 * 先访问/page/addRole
	 * 使用注解@RequestParam获取requestParamter
	 * @param role_name
	 * @param note
	 * @return
	 */
	@RequestMapping("requestParam")
	public ModelAndView requestParam(@RequestParam("roleName") String role_name,String note) {
		System.out.println("roleName->"+role_name);
		System.out.println("note->"+note);
		ModelAndView mv = new ModelAndView();
		Role role  = new Role();
		role.setRoleName(role_name);
		role.setNote(note);
		mv.addObject(role);
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}
	/**
	 * 使用@PathVariable注解获取Restful格式的参数（getRole/1）
	 * @param id
	 * @return
	 */
	@RequestMapping("getRole/{id}")
	public ModelAndView pathVariable(@PathVariable("id") Long id) {
		Role role = roleService.getRole(id);
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		mv.addObject(role);
		return mv;
	}
	
	/**
	 * 先访问/page/postJson，@RequestBody注解自动把JSON字符串转换成对象
	 * @param roleParams
	 * @return
	 */
	@RequestMapping(value="findRoles",method=RequestMethod.POST)
	public ModelAndView findRoles(@RequestBody RoleParams roleParams) {
		System.out.println("roleName=>"+roleParams.getRoleName());
		System.out.println("note=>"+roleParams.getNote());
		System.out.println("start=>"+roleParams.getPageParams().getStart());
		System.out.println("limit=>"+roleParams.getPageParams().getLimit());
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		mv.addObject(roleService.findRoles(roleParams));
		return mv;
	}
	
	/**
	 * 先访问/page/postJson，@RequestBody注解自动把JSON字符串转换成对象
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="deleteRoles",method=RequestMethod.POST)
	public ModelAndView deleteRoles(@RequestBody List<Long> ids) {
		System.out.println("ids=>"+ids);
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		mv.addObject(roleService.deleteRoles(ids));
		return mv;
	}
	
	/**
	 * 先访问/page/postJson，@RequestBody注解自动把JSON字符串转换成对象
	 * 
	 * @param roles
	 * @return
	 */
	@RequestMapping(value="addRoles",method=RequestMethod.POST,produces="text/plain;charset=utf-8")
	@ResponseBody
	public String addRoles(@RequestBody List<Role> roles) {
		System.out.println(JSON.toJSONString(roles));
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		roleService.addRoles(roles);
		mv.addObject(JSON.toJSONString(roles));
		System.out.println(JSON.toJSONString(roles));
		return JSON.toJSONString(roles);
	}
	/**
	 * 先访问/page/postJson，使用JS序列化form表单发送请求
	 * @param roleName
	 * @param note
	 * @return
	 */
	@RequestMapping(value="addRole",produces="text/plain;charset=utf-8")
	@ResponseBody()
	public String addRole(String roleName,String note) {
		Role role = new Role();
		role.setRoleName(roleName);
		role.setNote(note);
		roleService.addRole(role);
		System.out.println(JSON.toJSONString(role));
		return JSON.toJSONString(role);
	}
}
