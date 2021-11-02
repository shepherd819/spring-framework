package com.simba.lession1.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
public class UserService implements InitializingBean {
	@Autowired
	private OrderService orderService;

	@Autowired
	User admin;

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	UserService userService;
//	public UserService() {
//		System.out.println("1");
//	}

//	public UserService(OrderService orderService123) { //
//		this.orderService = orderService123;
//		System.out.println("2");
//	}

//	@Autowired //多个构造方法且没有无参的，需用autowired指定用哪个构造方法
//	public UserService(OrderService orderService, OrderService orderService2) {
//		this.orderService = orderService;
//		System.out.println("3");
//	}

//	@PostConstruct
//	public void a(){
//		//mysql -》User->admin
//	}
	@Transactional
	public void test(){
		jdbcTemplate.execute("insert into user values(9,1,1)");
		userService.a();
	}

	@Transactional(propagation = Propagation.NEVER)
	public void a(){

	}
	@Override
	public void afterPropertiesSet() throws Exception {

	}
}
