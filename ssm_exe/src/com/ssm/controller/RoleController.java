package com.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.pojo.Role;
import com.ssm.service.RoleService;

@Controller
@RequestMapping("role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	
	@RequestMapping("list")
	public String roleList(Model model) {
//		List<Role> roleList = roleService.findRoles(null);
		List<Role> roleList = new ArrayList<>();
		Role role = new Role();
		role.setId(1l);
		role.setRoleName("role_name_1");
		role.setNote("note_1");
		roleList.add(role);
		role = new Role();
		role.setId(2l);
		role.setRoleName("role_name_2");
		role.setNote("note_2");
		roleList.add(role);
		model.addAttribute("roleList", roleList);
		return "roleList";
	}
}
