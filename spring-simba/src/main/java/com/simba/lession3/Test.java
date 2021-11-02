package com.simba.lession3;

import com.simba.lession3.service.StringToUserPropertyEditor;
import com.simba.lession3.service.User;
import com.simba.lession3.service.UserService;
import org.springframework.beans.SimpleTypeConverter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.convert.support.ConversionServiceFactory;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

public class Test {
	public static void main(String[] args) throws IOException {
		AnnotationConfigApplicationContext ap = new AnnotationConfigApplicationContext(App.class);
//		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//		beanDefinition.setBeanClass(UserService.class);
//		ap.registerBeanDefinition("userService", beanDefinition);
//		AnnotatedBeanDefinitionReader beanDefinitionReader = new AnnotatedBeanDefinitionReader(ap);
//		beanDefinitionReader.registerBean(UserService.class);
////		beanDefinitionReader.register(UserService.class);
//		ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(ap);
//		int scan = scanner.scan("com.simba.lession3");

//		UserService userService = ap.getBean("userService", UserService.class);
//		UserService userService = ap.getBean("myFactoryBean", UserService.class);
		System.out.println(ap.getBean("myFactoryBean"));
		System.out.println(ap.getBean("myFactoryBean"));
		System.out.println(ap.getBean("myFactoryBean"));
//		userService.test();
//		String message = ap.getMessage("test", null, new Locale("en"));
//		System.out.println("message: " + message);
//		System.out.println(userService);

//		Resource resource = ap.getResource("file://D:\\data\\logs\\auto-mail.log");
//		System.out.println(resource.getFilename());
//		System.out.println(resource.contentLength());

//		environment(ap);
//		stringToUser();
//		stringToUserConverter();
//		simpleTypeConverter();
//		metaDataReader();

	}

	private static void metaDataReader() throws IOException {
		SimpleMetadataReaderFactory factory = new SimpleMetadataReaderFactory();
		MetadataReader metadataReader = factory.getMetadataReader("com.simba.lession3.service.UserService");
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		System.out.println(classMetadata.getClassName());
		System.out.println(classMetadata.getMemberClassNames()[0]);
		System.out.println("----------------------------------");
		System.out.println(annotationMetadata.hasAnnotation(Component.class.getName()));
		System.out.println(annotationMetadata.hasMetaAnnotation(Component.class.getName()));
		for (String annotationType : annotationMetadata.getAnnotationTypes())
		{
			System.out.println(annotationType);
		}
	}

	private static void simpleTypeConverter() {
		SimpleTypeConverter simpleTypeConverter = new SimpleTypeConverter();
//		simpleTypeConverter.registerCustomEditor(User.class, new StringToUserPropertyEditor());
		DefaultConversionService defaultConversionService = new DefaultConversionService();
		defaultConversionService.addConverter(new StringToUserConverter());
		simpleTypeConverter.setConversionService(defaultConversionService);
		User user = simpleTypeConverter.convertIfNecessary("2222", User.class);
		System.out.println(user.getName());
	}

	private static void stringToUserConverter() {
		DefaultConversionService defaultConversionService = new DefaultConversionService();
		defaultConversionService.addConverter(new StringToUserConverter());
		User convert = defaultConversionService.convert("111", User.class);
		System.out.println(convert.getName());
	}

	private static void stringToUser() {
		StringToUserPropertyEditor stringToUserPropertyEditor = new StringToUserPropertyEditor();
		stringToUserPropertyEditor.setAsText("shepherd");
		User value = (User) stringToUserPropertyEditor.getValue();
		System.out.println(value.getName());
	}

	private static void environment(AnnotationConfigApplicationContext ap) {
		Map<String, Object> systemEnvironment = ap.getEnvironment().getSystemEnvironment();
		System.out.println("systemEnvironment = " + systemEnvironment);
		Map<String, Object> systemProperties = ap.getEnvironment().getSystemProperties();
		System.out.println("systemProperties = " + systemProperties);
		MutablePropertySources propertySources = ap.getEnvironment().getPropertySources();
		System.out.println(propertySources);

		System.out.println(ap.getEnvironment().getProperty("NO_PROXY"));
		System.out.println(ap.getEnvironment().getProperty("sun.jnu.encoding"));
		System.out.println(ap.getEnvironment().getProperty("simba"));
	}
}
