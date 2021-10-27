package com.simba.lession1;

import com.simba.lession1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// bean的创建生命周期
// UserService.class -->无参构造方法-->对象-->依赖注入（属性赋值）--》初始化前()--》初始化()--》初始化后(AOP...)--》bean
// bean的销毁生命周期
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ap = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = ap.getBean("userService", UserService.class);
		userService.test();

//		class UserServiceProxy extends UserService{
//			UserService target;//生成代理类后把被代理对象保存下来，被代理对象经过了spring生命周期
//			@Override
//			public void test() {
//				//执行切面@Before逻辑
////				super.test();//父类
//				target.test();
//			}
//		}

//		System.out.println(ap.getBean("orderService"));
//		System.out.println(ap.getBean("orderService1"));
//		System.out.println(ap.getBean("orderService2"));
//		for (Field field : userService.getClass().getFields()) {
//			if (field.isAnnotationPresent(Autowired.class)) {
//				field.set(userService, ??);
//			}
//		}

//		for (Method method : userService.getClass().getMethods()) {
//			if (method.isAnnotationPresent(PostConstruct.class)) {
//				method.invoke(userService,null);
//			}
//		}
	}
}
