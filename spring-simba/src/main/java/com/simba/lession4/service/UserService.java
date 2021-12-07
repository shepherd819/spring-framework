package com.simba.lession4.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component
@Conditional(MyCondition.class)
//@Scope("prototype")
@DependsOn("orderService")
public class UserService implements SmartInitializingSingleton, DisposableBean {
	@Autowired
	private User user;
	public void test(){
		System.out.println("test");
	}

	@Resource
	private OrderService orderService;

	public UserService() {
		System.out.println("无参构造方法");
	}

	public UserService(OrderService orderService) {
		this.orderService = orderService;
		System.out.println("有参构造方法");
	}
	public User getUser(){
		return user;
	}
	@Override
	public void afterSingletonsInstantiated() {
		System.out.println("所有的非懒加载的单例bean都创建完了之后会调用每个非懒加载的单例bean此方法");
	}

	@Override
	public void destroy() throws Exception {
		//spring容器关闭close的时候执行
		System.out.println("userService销毁");
	}

	@PreDestroy
	public void destroy1(){
		System.out.println("userService销毁1");
	}


	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
}
