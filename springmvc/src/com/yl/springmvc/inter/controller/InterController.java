package com.yl.springmvc.inter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 调试拦截器的控制器
 * @author wby
 *
 */
@Controller
@RequestMapping("inter")
public class InterController {
	@RequestMapping("testInter")
	public String testInterceptor() {
		System.err.println("控制器进行处理。");
		return "inter/test";
	}
	
}
