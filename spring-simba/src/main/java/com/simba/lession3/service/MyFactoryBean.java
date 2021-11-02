package com.simba.lession3.service;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MyFactoryBean implements FactoryBean {
	@Override
	public Object getObject() throws Exception {
		return new UserService(); //没有经过完整bean的生命周期，只会走初始化后，走初始化后aop也会生效的
	}

	@Override
	public Class<?> getObjectType() {
		return UserService.class;
	}
}
