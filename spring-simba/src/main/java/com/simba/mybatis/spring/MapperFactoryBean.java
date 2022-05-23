package com.simba.mybatis.spring;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MapperFactoryBean implements FactoryBean {

	private Class interfaceClass;

	public MapperFactoryBean(Class interfaceClass) {
		this.interfaceClass = interfaceClass;
	}

	@Override
	public Object getObject() throws Exception {
		Object obj = Proxy.newProxyInstance(MapperFactoryBean.class.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("select by id");
				return null;
			}
		});
		return obj;
	}

	@Override
	public Class<?> getObjectType() {
		return interfaceClass;
	}
}
