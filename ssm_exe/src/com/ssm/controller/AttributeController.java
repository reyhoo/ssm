package com.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSON;
import com.ssm.pojo.Role;
import com.ssm.service.RoleService;

@Controller
@RequestMapping("attribute")
@SessionAttributes(names= {"loginRole"},types= {String.class})
public class AttributeController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="requestAttr",produces="application/json;charset=utf-8")
	@ResponseBody
	public String requestAttr(@RequestAttribute("id")Long id) {
		return JSON.toJSONString(roleService.getRole(id));
	}
	
	@RequestMapping(value="sessionAttr")
	@ResponseBody
	public Role sessionAttr(@SessionAttribute(value="testRoleId")Long id) {
		return roleService.getRole(id);
	}
	
	@RequestMapping(value="sessionAttributes")
	public String sessionAttributes(@RequestParam("id")Long id,Model model) {
		Role role = roleService.getRole(id);
		model.addAttribute("loginRole", role);
		model.addAttribute("roleName", role.getRoleName());
		return "redirect:/sessionAttributes.jsp";
	}
	
}
