package com.simba.lession3.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
//@Service
public class UserService implements ApplicationContextAware {

//	@Value("shepherd")
	private User user;

	private ApplicationContext applicationContext;

	public void test(){
//		applicationContext.publishEvent("11111");
//		System.out.println("test");
//		applicationContext.getMessage()
//		System.out.println(user.getName());
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	class innerClass{

	}
}
