package com.yl.springmvc.open.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
/**
 * 入门实例
 * @author wby
 *
 */
@Controller
@RequestMapping("/my")
public class MyController {

	@RequestMapping("/index")
	public ModelAndView index(@RequestParam(value="id")Long id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("open/index");
		return mv;
	}
}
