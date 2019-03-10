package com.ssm.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

	@Pointcut("execution(* com..*Service*.getRole(..))")
	public void print() {}
	@Before("print()")
	public void before() {
		System.err.println("TestAspect.before");
	}
}
