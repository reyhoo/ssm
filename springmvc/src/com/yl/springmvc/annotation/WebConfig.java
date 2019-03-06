//package com.yl.springmvc.annotation;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.web.multipart.MultipartResolver;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//import org.springframework.web.multipart.support.StandardServletMultipartResolver;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
//import com.yl.springmvc.App;
//
//@Configuration
//@ComponentScan(basePackageClasses=App.class)
//@EnableWebMvc
//@EnableTransactionManagement
//public class WebConfig {
//
//	@Bean(name="viewResolver")
//	public ViewResolver initViewResolver() {
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setSuffix(".jsp");
//		resolver.setPrefix("/WEB-INF/page/");
//		return resolver;
//	}
//	
//	/**
//	 * 使用StandardServletMultipartResolver要在MyWebAppInitializer的customizeRegistration方法中配置参数
//	 * 或者在web.xml进行配置
//	 * @return
//	 */
//	@Bean(name="multipartResolver")
//	public MultipartResolver initMultipartResolver() {
//		return new StandardServletMultipartResolver();
//	}
//	
//	/**
//	 * 如果使用CommonsMultipartResolver要引用第三方包。可以直接在该方法中配置相关参数。
//	 * @return
//	 */
//	@Bean(name="multipartResolver")
//	public MultipartResolver initCommonMultipartResolver() {
//		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//		return multipartResolver;
//	}
//}
