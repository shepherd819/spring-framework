package com.simba;

import com.simba.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean("userService", UserService.class);
		userService.test();
		userService.test();
		userService.test();
	}
}
