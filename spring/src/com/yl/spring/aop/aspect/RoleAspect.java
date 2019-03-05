package com.yl.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.yl.spring.aop.verifier.RoleVerifier;
import com.yl.spring.aop.verifier.impl.RoleVerifierImpl;
import com.yl.spring.pojo.Role;

@Aspect
@Component
public class RoleAspect {

	@DeclareParents(value="com.yl.spring.aop.service.impl.RoleServiceImpl+",defaultImpl=RoleVerifierImpl.class)
	public RoleVerifier roleVerifier;
	
	@Pointcut("execution(* com.yl.spring.aop.service.impl.RoleServiceImpl.printRole(..))")
	public void print() {}
	
	@Before("execution(* com.yl.spring.aop.service.impl.RoleServiceImpl.printRole(..)) && args(role)")
	public void before(Role role) {
		System.out.println("before...");
	}
	
	@After("print()")
	public void after() {
		System.out.println("after...");
	}
	
	@AfterReturning("print()")
	public void afterReturing() {
		System.out.println("afterReturing...");
	}
	@AfterThrowing("print()")
	public void afterThrowing() {
		System.out.println("afterThrowing...");
	}
	@Around("print()")
	public Object around(ProceedingJoinPoint pjp) {
		System.out.println("around before...");
		Object obj =null;
		try {
			obj = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
			//如果catch到异常这里不抛出，就会执行afterReturing。
		}
		System.out.println("around after...");
		return obj;
	}
}
