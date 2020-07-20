package com.huangxi;

import com.huangxi.service.WelcomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @description spring-framework构建测试
 * @date 2020-07-20
 */
public class MyApp {
	public static void main(String[] args) {
		System.out.println("hello world!");
		String dir = System.getProperty("user.dir");
		System.out.println("dir= "+dir);
		String xmlPath=".\\spring-demo\\src\\main\\resources\\spring\\spring-config.xml";
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(xmlPath);
		WelcomeService welcomeService = (WelcomeService) applicationContext.getBean("welcomeService");
		welcomeService.sayHello("spring-framework build test");
	}
}
