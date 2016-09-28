package com.test.action;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

public class LogBefore implements MethodBeforeAdvice {
	
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Override
	public void before(Method method, Object[] arg1, Object arg2)
			throws Throwable {
		logger.debug(method.getName()+arg1[0]+"doSomething Start...");
	}

}
