package com.yl.spring.aop.multi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.yl.spring.aop.multi.App;
import com.yl.spring.aop.multi.aspect.Aspect1;
import com.yl.spring.aop.multi.aspect.Aspect2;
import com.yl.spring.aop.multi.aspect.Aspect3;

@ComponentScan(basePackageClasses=App.class)
@EnableAspectJAutoProxy
public class MultiAspectConfig {
//	@Bean
//	public Aspect1 getAspect1() {
//		return new Aspect1();
//	}
//	
//	@Bean
//	public Aspect2 getAspect2() {
//		return new Aspect2();
//	}
//	
//	@Bean
//	public Aspect3 getAspect3() {
//		return new Aspect3();
//	}
}
