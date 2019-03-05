package com.yl.spring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.yl.spring.aop.aspect.RoleAspect;

@ComponentScan(basePackageClasses=AopConfig.class)
@EnableAspectJAutoProxy
public class AopConfig {
//	@Bean 经测试如果在切面类上加上@Component，这里就不用装配了。。//TODO
//	public RoleAspect getRoleAspect() {
//		return new RoleAspect();
//	}
}
