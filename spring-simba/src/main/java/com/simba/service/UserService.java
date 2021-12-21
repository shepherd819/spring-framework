package com.simba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class UserService {
	@Autowired
	OrderService orderService;

	public void test(){
		System.out.println(a());
	}

	@Lookup
	public OrderService a(){return null;}
}
