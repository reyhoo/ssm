package com.yl.springmvc.params.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {
	
	
	@RequestMapping("addRole")
	public String addRole() {
		return "role/addRoleForm";
	}
	
	@RequestMapping("postJson")
	public String sendJson() {
		return "param/postJson";
	}
}
