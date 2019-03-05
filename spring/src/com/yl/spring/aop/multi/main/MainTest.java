package com.yl.spring.aop.multi.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yl.spring.aop.multi.bean.MultiBean;
import com.yl.spring.aop.multi.config.MultiAspectConfig;

public class MainTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(MultiAspectConfig.class);
		MultiBean multiBean = cxt.getBean(MultiBean.class);
		multiBean.testMulti();
		cxt.close();
	}
}
