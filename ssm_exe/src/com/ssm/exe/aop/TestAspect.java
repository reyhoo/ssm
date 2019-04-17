package com.ssm.exe.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {

	@Before(value="execution(* com..getRole(..))")
	public void before() {
		System.err.println("TestAspect..before");
	}
	
}
