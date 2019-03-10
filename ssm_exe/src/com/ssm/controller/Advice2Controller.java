package com.ssm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.pojo.Role;
import com.ssm.service.RoleService;

@Controller
@RequestMapping("advice2")
public class Advice2Controller {

	@Autowired
	private RoleService roleService;
	
	
	@ModelAttribute("role")
	public Role getRole(@RequestParam(value="id",required=false) Long id) {
		if(id == null || id < 1) {
			return null;
		}
		return roleService.getRole(id);
	}
	@RequestMapping("modelAttribute")
	@ResponseBody
	public Map<String, Object>modelAttribute(@ModelAttribute("role") Role role,Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("role", role);
		map.put("role1", model.asMap().get("role"));
		map.put("role1 == role", model.asMap().get("role") == role);
		map.put("projectName", model.asMap().get("projectName"));
		return map;
	}
}
