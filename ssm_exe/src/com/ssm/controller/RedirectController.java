package com.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;
import com.ssm.pojo.Role;
import com.ssm.service.RoleService;

@Controller
@RequestMapping("redirect")
public class RedirectController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping("addRole")
	public String addRole(String roleName,String note,Model model) {
		Role role = new Role();
		role.setRoleName(roleName);
		role.setNote(note);
		roleService.addRole(role);
		model.addAttribute("id", role.getId());
		model.addAttribute("roleName", role.getRoleName());
		model.addAttribute("note", role.getNote());
		return "redirect:/redirect/showJsonInfo";
	}
	
	@ResponseBody
	@RequestMapping(value="showJsonInfo",produces="application/json;charset=UTF-8")
	public String showJsonInfo(Long id,String roleName,String note) {
		Role role = new Role();
		role.setId(id);
		role.setRoleName(roleName);
		role.setNote(note);
		return JSON.toJSONString(role);
	}
	
	@RequestMapping("addRole2")
	public String addRole2(String roleName,String note,RedirectAttributes ra) {
		Role role = new Role();
		role.setRoleName(roleName);
		role.setNote(note);
		roleService.addRole(role);
		ra.addFlashAttribute("role", role);
		return "redirect:/redirect/showJsonInfo2";
	}

	@RequestMapping("showJsonInfo2")
	@ResponseBody
	public Role showJsonInfo2(Role role) {
		return role;
	}
	
}
