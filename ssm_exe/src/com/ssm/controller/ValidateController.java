package com.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.pojo.Transaction;

@Controller
@RequestMapping("validate")
public class ValidateController {
	
	
	
@RequestMapping("test")
@ResponseBody
	public Map<String, Object> valid(@Valid Transaction transaction,Errors errors){
		Map<String, Object>map = new HashMap<String, Object>();
		if(errors.hasFieldErrors()) {
			map.put("passed", "NO");
			List<FieldError> fieldErrors = errors.getFieldErrors();
			for (FieldError fieldError : fieldErrors) {
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
		}else {
			map.put("passed", "YES");
		}
		return map;
	}
	
}
