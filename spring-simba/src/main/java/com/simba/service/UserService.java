package com.simba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component
@Scope("prototype")
public class UserService {
	@Autowired
	OrderService orderService;

	public UserService(OrderService orderService){
		System.out.println("1个参数构造方法");
	}

	@Autowired
	public UserService(OrderService orderService, OrderService orderService1){
		System.out.println("2个参数构造方法");
	}

	public void test(){
		System.out.println(orderService);
	}
}
