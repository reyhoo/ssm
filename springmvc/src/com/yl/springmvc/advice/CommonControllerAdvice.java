package com.yl.springmvc.advice;

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

//标识控制器通知，并且指定对应的包
//只对指定包或者子包下的控制器起作用
@ControllerAdvice(basePackageClasses=CommonControllerAdvice.class)
public class CommonControllerAdvice {

	//定义HTTP对应参数处理规则
	@InitBinder
	public void initBinder(DataBinder binder) {
		//针对日期类型的格式化，其中CustomDateEditor是客户自定义编辑器
		//它的boolean参数表示是否允许为空
		binder.registerCustomEditor(Date.class, 
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
		
	}
	//在控制器方法访问前保存在数据模型里
	@ModelAttribute
	public void populateModel(Model model) {
		model.addAttribute("projectName", "controllerAdvice");
	}
	//控制器的方法访问异常时调用该方法，跳转到指定页面；并且可以指定异常类型，当前为Exception
	@ExceptionHandler(Exception.class)
	public String exception(Model model,Exception e) {
		System.err.println(e);
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		model.addAttribute("info", sw.toString());
		return "exception";
	}
}
