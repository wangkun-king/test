package com.test.action;


import com.test.service.LogBookService;


public class LogBook implements LogBookService{
	
	@Override
	public void doSomething(String name){
//		PropertyConfigurator.configure("log4j.properties");
//		logger.debug(name+"dolog");
//		logger.debug(name+"dolog 结束");
		System.out.println("LogBook: doSomething...");
	}
	
}
