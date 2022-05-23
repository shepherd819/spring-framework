package com.simba;

import com.simba.aop.MyAfterReturningAdvice;
import com.simba.aop.MyBeforeAdvice;
import com.simba.aop.MyTrowsAdvice;
import com.simba.service.OrderService;
import com.simba.service.UserService;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.stereotype.Component;

public class MyApplication {
	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = (UserService) context.getBean("userService");
		userService.test();
//		SimpleMetadataReaderFactory simpleMetadataReaderFactory = new SimpleMetadataReaderFactory();
//		MetadataReader metadataReader = simpleMetadataReaderFactory.getMetadataReader(UserService.class.getName());
//		ClassMetadata classMetadata = metadataReader.getClassMetadata();
//		Resource resource = metadataReader.getResource();
//		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
//		System.out.println(annotationMetadata.hasMetaAnnotation(Component.class.getName()));
	}

	public static void test() throws Exception {
		UserService userService = new UserService();

		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(userService);
		proxyFactory.addAdvice(new MyBeforeAdvice());
		proxyFactory.addAdvice(new MyAfterReturningAdvice());
		proxyFactory.addAdvice(new MyTrowsAdvice());
		UserService proxy = (UserService) proxyFactory.getProxy();
		proxy.test();
//		proxy.testa();
	}
}
