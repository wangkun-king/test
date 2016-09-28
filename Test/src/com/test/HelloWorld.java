package com.test;

import java.util.Date;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class HelloWorld {
	private String msg;
	private Date date;
	private Student name;
	private List<String> list;
	
	
	public Student getName() {
		return name;
	}

	public void setName(Student name) {
		this.name = name;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		ApplicationContext actx = new FileSystemXmlApplicationContext("applicationContext.xml");
		HelloWorld hello = (HelloWorld) actx.getBean("helloworld");
		System.out.println(hello.getMsg()+"\t"+hello.getDate()+hello.getName().getName());
//		List<String> l = hello.getList();
//		for (String string : l) {
//			System.out.println(string);
//		}
//		Object[] obj = new Object[]{"hahahahh",Calendar.getInstance().getTime()};
//		hello.setMsg(actx.getMessage("HelloWorld", obj, Locale.CHINA));
//		System.out.println(hello.getMsg());
//		System.out.println("***************");
//		LogEvent event = new LogEvent("loge");
//		actx.publishEvent(event);
		
//		LogBook lb = new LogBook();
//		lb.doLog1("王坤");
		
//		LogBookProxy logProxy = new LogBookProxy();
//		LogBookService logService = (LogBookService)logProxy.bind(new LogBook());
//		logService.doSomething("王坤");
		
//		ApplicationContext actx = new FileSystemXmlApplicationContext("applicationContext.xml");
//		LogBookService logService = (LogBookService) actx.getBean("logProxy");
//		logService.doSomething("王坤");
		
	}
}
