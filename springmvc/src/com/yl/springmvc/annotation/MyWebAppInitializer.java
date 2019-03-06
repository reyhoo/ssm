//package com.yl.springmvc.annotation;
//
//import javax.servlet.Filter;
//import javax.servlet.MultipartConfigElement;
//import javax.servlet.ServletRegistration.Dynamic;
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
//	/**
//	 * 如果multipartResolver使用的是StandardServletMultipartResolver要在初始化的时候在该方法里设置相关参数。
//	 * 如果使用xml方式配置StandardServletMultipartResolver，要在web.xml的<servlet></servlet>里配置相关参数。
//	 */
//	@Override
//	protected void customizeRegistration(Dynamic dynamic) {
//		String filePath = "d:\\mvc\\uploads";
//		Long singleMax = (long) (5 * Math.pow(2, 20));
//		Long totalMax = (long) (10 * Math.pow(2, 20));
//		dynamic.setMultipartConfig(new MultipartConfigElement(filePath, singleMax, totalMax, 0));
//	}
//
//}
