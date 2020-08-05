package com.huangxi;

import com.huangxi.controller.WelcomeController;
import com.huangxi.entity.User;
import com.huangxi.entity.factory.UserFactoryBean;
import com.huangxi.service.WelcomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @description spring-framework构建测试
 * @date 2020-07-20
 */

// 解析注解类测试
@Configuration
@ComponentScan("com.huangxi")
public class MyApp {
	public static void main1(String[] args) {
		System.out.println("hello world!");
		String dir = System.getProperty("user.dir");
		System.out.println("dir= "+dir);
		String xmlPath=".\\spring-demo\\src\\main\\resources\\spring\\spring-config.xml";
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(xmlPath);
		WelcomeService welcomeService = (WelcomeService) applicationContext.getBean("welcomeService");
		welcomeService.sayHello("spring-framework build test");

		//得到无参构造函数创建的对象
		User user1a = (User) applicationContext.getBean("user1");
		User user1b = (User) applicationContext.getBean("user1");
		//得到静态工厂创建的对象
		User user2a = (User) applicationContext.getBean("user2");
		User user2b = (User) applicationContext.getBean("user2");
		//得到实例工厂创建的对象
		User user3a = (User) applicationContext.getBean("user3");
		User user3b = (User) applicationContext.getBean("user3");

		//这样只能获取到user对象
		User user4a = (User) applicationContext.getBean("userFactoryBean");
		User user4b = (User) applicationContext.getBean("userFactoryBean");

		//获取factoryBean对象需要通过 &
		UserFactoryBean user5a = (UserFactoryBean) applicationContext.getBean("&userFactoryBean");
		UserFactoryBean user5b = (UserFactoryBean) applicationContext.getBean("&userFactoryBean");


		System.out.println("user1a="+user1a);
		System.out.println("user1b="+user1b);
		System.out.println("user2a="+user2a);
		System.out.println("user2b="+user2b);
		System.out.println("user3a="+user3a);
		System.out.println("user3b="+user3b);
		System.out.println("user4a="+user4a);
		System.out.println("user4b="+user4b);
		System.out.println("user5a="+user5a);
		System.out.println("user5b="+user5b);
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyApp.class);
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for(String beanDefinition: beanDefinitionNames){
			System.out.println(beanDefinition);
		}
		WelcomeService welcomeService = (WelcomeService) applicationContext.getBean("welcomeServiceImpl");
		welcomeService.sayHello("spring-framework build test");
		WelcomeController welcomeController = (WelcomeController) applicationContext.getBean("welcomeController");
		welcomeController.handleRequest();
		//com.huangxi.postprocessor.CustomizedBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry
		User userPostProcessor = (User) applicationContext.getBean("userPostProcessor");
		System.out.println("CustomizedBeanDefinitionRegistryPostProcessor create bean: "+userPostProcessor);
	}
}
