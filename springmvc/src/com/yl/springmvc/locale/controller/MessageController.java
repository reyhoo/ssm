package com.yl.springmvc.locale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@RequestMapping("message")
@Controller
public class MessageController {
	
	@RequestMapping("msgpage")
	public String msgpage() {
		return "message";
	}
	
}
