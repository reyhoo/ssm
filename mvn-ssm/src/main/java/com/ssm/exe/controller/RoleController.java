package com.ssm.exe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ssm.exe.pojo.Role;
import com.ssm.exe.service.RoleService;

@Controller
@RequestMapping("role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	@RequestMapping("getRole/{id}")
	@ResponseBody
	public Role getRole(@PathVariable("id")Long id) {
		return roleService.getRole(id);
	}
	@RequestMapping(value="getRole1",produces="application/json;charset=utf-8")
	@ResponseBody
	public String getRole1(Long id) {
		Role role = roleService.getRole(id);
		return JSON.toJSONString(role);
	}

	@RequestMapping(value = "list")
	public String list(Model model){
		model.addAttribute("roleList",roleService.getAll());
		return "role/list";
	}


	@RequestMapping(value = "modify")
	public String modify(Role role){
		roleService.modifyRole(role);
		return "redirect:/role/list";
	}

	@RequestMapping(value = "add")
	public String add(Role role){
		roleService.addRole(role);
		return "redirect:/role/list";
	}

	@RequestMapping(value = "delete")
	public String delete(Long id){
		roleService.delete(id);
		return "redirect:/role/list";
	}
}
