package com.simba.lession1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class MyAspect {

	@Before("execution(public void com.simba.lession1.service.UserService.test())")
	public void before(JoinPoint joinPoint){
		System.out.println("before");
	}
}
