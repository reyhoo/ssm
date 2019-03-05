package com.yl.springmvc.exe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.yl.springmvc.exe.service.RoleService;

@Controller
@RequestMapping("role")
public class RoleController {
	@Autowired
	private RoleService roleSerivce;
	
	@RequestMapping(value="getRole",method=RequestMethod.GET)
	public ModelAndView getRole(@RequestParam("id")Long id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("role/detail");
		mv.addObject("role", roleSerivce.getRole(id));
		return mv;
	}
	@RequestMapping(value="getRoleJson",method=RequestMethod.GET)
	public ModelAndView getRoleJson(@RequestParam("id")Long id) {
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		mv.addObject("role", roleSerivce.getRole(id));
		return mv;
	}
}
