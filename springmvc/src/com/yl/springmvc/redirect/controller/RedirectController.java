package com.yl.springmvc.redirect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.alibaba.fastjson.JSON;
import com.yl.springmvc.params.service.RoleService;
import com.yl.springmvc.pojo.Role;

@Controller
@RequestMapping("redirect")
public class RedirectController {
	@Autowired
	private RoleService roleService;
	/**
	 * 重定向使用requestParam接收参数。
	 * @param id
	 * @param roleName
	 * @param note
	 * @return
	 */
	@RequestMapping("showRoleJsonInfo")
	public ModelAndView showRoleJsonInfo(@RequestParam("id")Long id,
			@RequestParam(value="roleName",required=false)String roleName,
			@RequestParam(value="roleName",required=false)String note) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);
		mv.addObject("roleName", roleName);
		mv.addObject("note", note);
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}
	
	/**
	 * 使用Model对象绑定重定向数据模型(简单参数，如字符串)
	 * ModelAndView或者Model设置的数据模型实际上是requestAttribute，
	 *  等重定向时当作requestParam拼接在重定向链接上，而不是requestAttribute，重定向也接收不了requestAttribute。
	 * @param model
	 * @param roleName
	 * @param note
	 * @return
	 */
	@RequestMapping(value="addRole",method=RequestMethod.GET)
	public String addRole(Model model,String roleName,String note) {
		Role role = new Role();
		role.setRoleName(roleName);
		role.setNote(note);
		roleService.addRole(role);
		model.addAttribute("id", role.getId());
		model.addAttribute("roleName", role.getRoleName());
		model.addAttribute("note", role.getNote());
		return "redirect:showRoleJsonInfo";
	}
	
	/**
	 *  使用ModelAndView对象绑定重定向数据模型(简单参数，如字符串)，
	 *  ModelAndView或者Model设置的数据模型实际上是requestAttribute，
	 *  等重定向时当作requestParam拼接在重定向链接上，而不是requestAttribute，重定向也接收不了requestAttribute。
	 * @param mv
	 * @param roleName
	 * @param note
	 * @return
	 */
	@RequestMapping(value="addRole2",method=RequestMethod.GET)
	public ModelAndView addRole2(ModelAndView mv,String roleName,String note) {
		Role role = new Role();
		role.setRoleName(roleName);
		role.setNote(note);
		roleService.addRole(role);
		mv.addObject("id", role.getId());
		mv.addObject("roleName", role.getRoleName());
		mv.addObject("note", role.getNote());
		mv.setViewName("redirect:showRoleJsonInfo");
		return mv;
	}
	/**
	 * 使用RedirectAttributes对象绑定重定向数据模型(传递java对象)，
	 * 实际上是临时设置在session里，等重定向后清除。
	 * @param ra
	 * @param role
	 * @return
	 */
	@RequestMapping(value="addRole3",method=RequestMethod.GET)
	public String addRole2(RedirectAttributes ra,Role role) {
		roleService.addRole(role);
		ra.addFlashAttribute("role", role);
		return "redirect:showRoleJsonInfo2";
	}
	/**
	 * 重定向接收RedirectAttributes传递的复杂对象参数
	 * @param role
	 * @return
	 */
	@RequestMapping(value="showRoleJsonInfo2",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String showRoleJsonInfo2(Role role) {
		role.setNote(role.getNote()+"备注");
		return JSON.toJSONString(role);
	}
	
	
}
