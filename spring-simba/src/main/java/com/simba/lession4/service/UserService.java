package com.simba.lession4.service;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(MyCondition.class)
public class UserService {
	public void test(){
		System.out.println("test");
	}
}
