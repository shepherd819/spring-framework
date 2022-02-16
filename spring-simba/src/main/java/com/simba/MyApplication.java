package com.simba;

import com.simba.service.OrderService;
import com.simba.service.UserService;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = (UserService) context.getBean("userService");
		UserService userService1 = (UserService) context.getBean("userService");
		userService.test();
	}
}
