package com.ssm.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("format")
public class FormatController {

	@RequestMapping("formatParams")
	@ResponseBody
	public Map<String, Object> formatParams(@DateTimeFormat(pattern="yyyy-MM-dd")Date date,
			@NumberFormat(pattern="#,###.00")BigDecimal amount) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date", date == null?null:date.toString());
		map.put("amount", amount);
		return map;
	}
}
