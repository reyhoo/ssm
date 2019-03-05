package com.yl.springmvc.validate.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yl.springmvc.validate.pojo.Transaction;
import com.yl.springmvc.validate.validator.TransactionValidator;

@Controller
@RequestMapping("validate")
public class ValidateController {

	/**
	 * 绑定自定义的验证器（Validator）,处理比较复杂的验证逻辑。
	 * 特别注意的是，不会先进行注解的简单验证，然后进行自定义的验证器验证，而是直接走自定义的验证器。
	 * @param binder
	 */
	
//	@InitBinder
//	public void initBinder(DataBinder binder) {
//		binder.setValidator(new TransactionValidator());
//	}
	/**
	 * 进入form表单页面
	 * @return
	 */
	@RequestMapping("toFormPage")
	public String toFormPage() {
		return "vali/validate";
	}
	/**
	 *一.实体参数上有@Valid，会按照实体中参数的注解配置进行验证，
	 *如果验证不过：
	 *      1.该方法中有errors参数，errors参数里包含了所有参数格式错误信息（包括注解配置和参数转换异常），
	 *         接口访问不会出现访问异常。
	 *      2.如果该方法中没有errors参数，会出现接口访问异常。
	 *二.如果没有@Valid就不会按照实体中参数的注解配置进行验证，但是如果出现参数转换异常，
	 *		1.errors中也会有错误信息，并且接口访问不会出现错误。
	 *      2.但是如果该方法中没有errors参数并且出现参数转换异常，接口就会出现访问异常。
	 * @param transaction
	 * @param errors
	 * @return
	 */
	@RequestMapping(value="annotation",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String annotationValidate(@Valid Transaction transaction , Errors errors) {
		StringBuilder sb = new StringBuilder();
		if(errors.hasFieldErrors()) {
			List<FieldError> errorList = errors.getFieldErrors();
			for (FieldError fieldError : errorList) {
				sb.append("field:");
				sb.append(fieldError.getField());
				sb.append("\t");
				sb.append("msg:");
				sb.append(fieldError.getDefaultMessage());
				sb.append('\n');
			}
			return sb.toString();
		}
		return transaction.toString();
	}
	
}
