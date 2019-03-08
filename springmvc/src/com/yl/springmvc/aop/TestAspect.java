package com.yl.springmvc.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {

	@Pointcut("execution(* com.yl.springmvc.params.service.impl.RoleServiceImpl.getRole(..))")
	public void print() {}
	
	@Before("execution(* com..getRole(..))")
	public void before() {
		System.err.println("TestAspect.before()");
	}
}
