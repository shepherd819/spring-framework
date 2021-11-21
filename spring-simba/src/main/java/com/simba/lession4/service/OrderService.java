package com.simba.lession4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
//@DependsOn("userService")
public class OrderService {

	@Autowired
	private User user;


	@Lookup("user")
	public User a(){return null;};

	public void test(){
//		System.out.println(user);
		System.out.println(a());
	}
}
