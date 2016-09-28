package com.test.action;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LogAround implements MethodInterceptor {

	private Logger logger = Logger.getLogger(this.getClass().getName());
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		logger.log(Level.INFO, mi.getArguments()[0]+"doSomething Start....");
		try {
			Object result = mi.proceed();
			return result;
			
		} finally{
			logger.debug(mi.getArguments()[0]+"doSomething End....");
		}
	}

}
