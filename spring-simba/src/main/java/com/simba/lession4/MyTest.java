package com.simba.lession4;

import com.simba.lession4.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyApp.class);
		OrderService orderService = context.getBean("orderService", OrderService.class);

	}
}
