package com.yl.springmvc.advice.contoller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//事实上，@InitBinder,@ExceptionHandler,@ModelAttribute也可以用在控制器（@Controller注解）上,
//但是只是对当前控制器有效，详情代码查看advice1包下的控制器。
@Controller
@RequestMapping("advice")
public class MyAdviceController {

	@RequestMapping("test")
	@ResponseBody
	public Map<String, Object> testAdvice(Date date,
			@NumberFormat(pattern="#,###.00")BigDecimal amount,Model model){
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("projectName", model.asMap().get("projectName"));
		map.put("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
		map.put("amount", amount);
		return map;
	}
	@RequestMapping("exception")
	public void exception() {
		throw new RuntimeException("测试异常跳转");
	}
}
