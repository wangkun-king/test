package com.test.service;

import java.lang.reflect.Method;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

public class LogBookProxy implements InvocationHandler {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private Object obj;
	public Object bind(Object obj){
		this.obj=obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;
		try{
			logger.debug(method.getName()+":"+ args[0]+"doSomething Start....");
			result = method.invoke(obj, args);
			logger.debug(method.getName()+":"+ args[0]+"doSomething end....");
		}catch(Exception e){
			logger.debug(e.toString());
		}
		return result;
	}

}
