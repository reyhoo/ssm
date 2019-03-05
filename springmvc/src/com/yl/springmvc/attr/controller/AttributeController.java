package com.yl.springmvc.attr.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSON;
import com.yl.springmvc.params.service.RoleService;
import com.yl.springmvc.pojo.Role;

@Controller
@RequestMapping("attr")
//使用Model或者ModelAndView设置数据模型时，
//如果key在指定的names列表中或者value的类型在指定的types列表中，那就会把该数据模型设置中session中。
@SessionAttributes(names= {"id"},types= {Role.class})
public class AttributeController {
	@Autowired
	private RoleService roleService;
	/**
	 * 访问/sendAttr.jsp页面，页面中在request设置attribute,然后转发到该接口，
	 * 该方法使用@RequestAttibute注解获取attribute，然后转换成JSON数据返回。
	 * @param id
	 * @return
	 */
	@RequestMapping(value="requestAttribute",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String reqAttr(@RequestAttribute("id") Long id) {
		Role role = roleService.getRole(id);
		return JSON.toJSONString(role);
	}
	/**
	 * 访问/sendAttr.jsp页面，页面中在request设置attribute,然后转发到该接口，
	 * 该方法使用@RequestAttibute注解获取attribute，然后转发到role/detail页面。
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="requestAttribute2")
	public String reqAttr2(@RequestAttribute("id") Long id,Model model) {
		Role role = roleService.getRole(id);
		model.addAttribute("role", role);
		return "role/detail";
	}
	/**
	 * 类体上的@SessionAttributes注解用来在session上设置attribute，然后重定向到页面，页面上从session中获取。
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="sessionAttrs")
	public String sessionAttrs( Long id,Model model) {
		Role role = roleService.getRole(id);
		model.addAttribute("role", role);
		model.addAttribute("id", id);
//		String contextPath = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getContextPath();
		return "redirect:/sessionAttrs.jsp";
	}
	
	/**
	 * 先访问/setSessionAttr.jsp，在页面中设置sessionAttribute("id",xx)，
	 * 然后再访问该接口使用@SessionAttribute获取sessionAttribute
	 * @param id
	 * @return
	 */
	@RequestMapping(value="sessionAttr",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String sessionAttr(@SessionAttribute("id")Long id) {
		return JSON.toJSONString(roleService.getRole(id));
	}
	/**
	 * 获取请求头和Cookie
	 * @param userAgent
	 * @param jsessionId
	 * @return
	 */
	@RequestMapping(value="getHeaderAndCookie")
	@ResponseBody
	public String testHeaderAndCookie(@RequestHeader(defaultValue="attribute",
	required=false,value="User-Agent")String userAgent,
			@CookieValue(defaultValue="MyJsessionId",
			required=false,value="JSESSIONID")String jsessionId) {
		Map<String, String>map = new HashMap<String, String>();
		map.put("userAgent", userAgent);
		map.put("jsessionId", jsessionId);
		return JSON.toJSONString(map);
	}
	
}
