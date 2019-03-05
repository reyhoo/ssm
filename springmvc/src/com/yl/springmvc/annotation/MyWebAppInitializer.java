//package com.yl.springmvc.annotation;
//
//import javax.servlet.Filter;
//
//import org.springframework.web.filter.CharacterEncodingFilter;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//	@Override
//	protected Class<?>[] getRootConfigClasses() {
//		return new Class<?>[] {ApplicationConfig.class};
//	}
//
//	@Override
//	protected Class<?>[] getServletConfigClasses() {
//		return new Class<?>[] {WebConfig.class};
//	}
//	
//	@Override
//	protected Filter[] getServletFilters() {
//		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//		characterEncodingFilter.setForceEncoding(true);
//		characterEncodingFilter.setEncoding("UTF-8");
//		return new Filter[] {characterEncodingFilter};
//	}
//
//	@Override
//	protected String[] getServletMappings() {
//		return new String[] {"/"};
//	}
//
//}
