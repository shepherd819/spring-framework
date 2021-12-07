package com.simba.lession4;

import com.simba.lession4.service.OrderService;
import com.simba.lession4.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
	public static void main(String[] args) {
//		annotation();
//		xml();
		circleDependency();
	}

	public static void circleDependency(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyApp.class);
		context.getBean("AService");
		context.getBean("BService");
	}

	private static void annotation() {
		//		AnnotationConfigApplicationContext parent = new AnnotationConfigApplicationContext(MyApp1.class);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(MyApp.class);
//		context.setParent(parent);
		context.refresh();
		UserService userService = (UserService) context.getBean("userService");
//		UserService service = (UserService) context.getBean("userService", new OrderService()); //原型的调用有参的构造方法

//		ClassPathXmlApplicationContext ap = new ClassPathXmlApplicationContext("spring.xml");
//		Object user = ap.getBean("user");

		context.registerShutdownHook();//也会触发bean销毁
//		context.close();
	}

	private static void xml(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserService userService = context.getBean("userService", UserService.class);
		System.out.println(userService.getUser());
	}
}
