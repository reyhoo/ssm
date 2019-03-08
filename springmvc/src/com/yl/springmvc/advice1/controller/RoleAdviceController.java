package com.yl.springmvc.advice1.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yl.springmvc.params.service.RoleService;
import com.yl.springmvc.pojo.Role;


//@InitBinder,@ExceptionHandler,@ModelAttribute也可以用在控制器（@Controller注解）上,
//但是只是对当前控制器有效.
@Controller
@RequestMapping("roleAdvice")
public class RoleAdviceController {

	
	@Autowired
	private RoleService roleService;
	
	/**
	 * 注册日期格式转换器
	 * @param binder
	 */
	@InitBinder
	public void initBinder(DataBinder binder) {
		binder.registerCustomEditor(Date.class, 
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
	}
	/**
	 * 在进入控制器方法运行，先从数据库中查询角色，然后以键role保存角色对象到数据模型
	 * @param id
	 * @return
	 */
	@ModelAttribute("role")
	public Role initRole(@RequestParam(value="id",required=false)Long id) {
		if(id == null || id < 1) {
			return null;
		}
		return roleService.getRole(id);
	}
	
	/**
	 *  ModelAttribute注解从数据模型中取出数据
	 *  http://localhost:8080/springmvc/roleAdvice/getRoleFromModelAttribute?id=21&date=19900203
	 * @param role
	 * @param date
	 * @param model
	 * @return
	 */
	@RequestMapping("getRoleFromModelAttribute")
	@ResponseBody
	public Role getRoleFromModelAttribute(@ModelAttribute("role") Role role,Date date,Model model) {
		System.err.println(model.asMap().get("projectName"));//不能取到，CommonControllerAdvice通知里保存的，当前控制器不在它所在的包或者子包下。
		System.err.println(model.asMap().get("role")); //当前控制器保存的，可以取到
		System.err.println(date);
		if(role == null) {
			throw new RoleException("未找到角色对象");
		}
		return role;
	}
	 /**
	  * 当该控制器发生RoleException异常时,执行该方法，跳转到指定页面,其它异常还是走系统的页面
	  * @param model
	  * @param e
	  * @return
	  */
	@ExceptionHandler(RoleException.class)
	public String exception(Model model,Exception e) {
		System.err.println(e);
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		model.addAttribute("info", sw.toString());
		return "exception";
	}
}
