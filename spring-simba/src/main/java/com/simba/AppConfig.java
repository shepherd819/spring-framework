package com.simba;

import com.simba.mybatis.spring.SimbaMapperScan;
import com.simba.service.OrderService;
import com.simba.service.UserService;
import org.aopalliance.aop.Advice;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.lang.reflect.Method;

@ComponentScan
@Configuration
//@EnableAspectJAutoProxy
//@Component
//@SimbaMapperScan("com.simba.mapper")
//@MapperScan
//@EnableTransactionManagement
public class AppConfig {

	@Bean("userService")
	public UserService userService(){
		System.out.println(orderService());
		return new UserService();
	}

	@Bean("orderService")
	public OrderService orderService(){
		return new OrderService();
	}

	public PointcutAdvisor advisor(){
		return new PointcutAdvisor() {
			//切点
			@Override
			public Pointcut getPointcut() {
				return new Pointcut() {
					@Override
					public ClassFilter getClassFilter() {
						return new ClassFilter() {
							@Override
							public boolean matches(Class<?> clazz) {
								//1先匹配类
								return true;
							}
						};
					}

					@Override
					public MethodMatcher getMethodMatcher() {
						return new MethodMatcher() {
							@Override
							public boolean matches(Method method, Class<?> targetClass) {
								//2类匹配成功，匹配此方法
								return false;
							}

							@Override
							public boolean isRuntime() {
								return false;
							}

							@Override
							public boolean matches(Method method, Class<?> targetClass, Object... args) {
								//isRuntime为true会匹配此方法
								return false;
							}
						};
					}
				};
			}

			//切面
			@Override
			public Advice getAdvice() {
				return new MethodBeforeAdvice() {
					@Override
					public void before(Method method, Object[] args, Object target) throws Throwable {
						System.out.println("beforemethod......");
					}
				};
			}

			@Override
			public boolean isPerInstance() {
				return false;
			}
		};
	}


}
