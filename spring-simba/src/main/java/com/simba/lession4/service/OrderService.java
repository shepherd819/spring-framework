package com.simba.lession4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class OrderService {

	@Autowired
	private User user;

	@Lookup("user")
	public abstract User a();

	public void test(){
//		System.out.println(user);
		System.out.println(a());
	}
}
