package com.ssm.advice.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("advice")
public class MyAdviceController {

	@RequestMapping("test")
	@ResponseBody
	public Map<String, Object>test(Date date,Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("date", date == null ? null:date.toString());
		map.put("projectName", model.asMap().get("projectName"));
		return map;
	}
	
	@RequestMapping("exception")
	public void exception() {
		throw new RuntimeException("≤‚ ‘“Ï≥£");
	}
}
