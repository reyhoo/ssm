package com.ssm.advice;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(basePackageClasses=CommonControllerAdvice.class)
public class CommonControllerAdvice {

	@InitBinder
	public void initBinder(DataBinder dataBinder) {
		dataBinder.registerCustomEditor(Date.class, 
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
	}
	
	@ModelAttribute
	public void ModelAttr(Model model) {
		model.addAttribute("projectName", "ssm_exe");
	}
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public String exception(Exception e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString();
	}
}
