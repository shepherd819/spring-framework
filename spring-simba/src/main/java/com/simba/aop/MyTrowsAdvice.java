package com.simba.aop;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class MyTrowsAdvice implements ThrowsAdvice {
	public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
		System.out.println("发生异常之后");
	}
}
