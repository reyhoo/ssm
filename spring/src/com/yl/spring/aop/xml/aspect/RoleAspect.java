package com.yl.spring.aop.xml.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import com.yl.spring.pojo.Role;

public class RoleAspect {

	public void before(Role role) {
		System.out.println("role_id"+role.getId()+".before...");
	}
	
	public void after() {
		System.out.println("after...");
	}
	
	public void afterReturing() {
		System.out.println("afterReturing...");
	}
	public void afterThrowing() {
		System.out.println("afterThrowing...");
	}
	
	public void around(ProceedingJoinPoint pjp) {
		System.out.println("around before...");
		Object obj =null;
		try {
			obj = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
			//如果catch到异常这里不抛出，就会执行afterReturing。
		}
		System.out.println("around after...");
	}
}
