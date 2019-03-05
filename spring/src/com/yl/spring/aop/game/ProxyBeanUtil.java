package com.yl.spring.aop.game;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBeanUtil implements InvocationHandler {
	
	//被代理的对象
	private Object obj;
	
	private Interceptor interceptor;
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object retObj = null;
		boolean exceptionFlag = false;
		interceptor.before(obj);
		try {
			
			retObj = method.invoke(obj, args);
		} catch (Exception e) {
			e.printStackTrace();
			exceptionFlag = true;
		}finally {
			interceptor.after(obj);
		}
		if(exceptionFlag) {
			interceptor.afterThrowing(obj);
		}else {
			interceptor.afterReturning(obj);
		}
		return retObj;
	}
	
	public static Object getBean(Object obj,Interceptor interceptor) {
		ProxyBeanUtil _this = new ProxyBeanUtil();
		_this.obj = obj;
		_this.interceptor = interceptor;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), _this);
	}

	
}
