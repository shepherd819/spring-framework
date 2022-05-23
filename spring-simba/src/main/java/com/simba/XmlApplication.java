package com.simba;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Object user = context.getBean("user");
		System.out.println(user);
	}
}
