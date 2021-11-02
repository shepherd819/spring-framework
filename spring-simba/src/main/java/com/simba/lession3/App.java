package com.simba.lession3;

import com.simba.lession3.service.UserService;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ConversionServiceFactoryBean;

import java.util.Collections;

@ComponentScan
//@ComponentScan(value = "com.simba.lession3.service", excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = UserService.class)})
@PropertySource(value = "classpath:simba.properties",encoding = "utf-8")
public class App {

//todo 待完成报错，未实现
//	@Bean
//	public ConversionServiceFactoryBean conversionServiceFactoryBean(){
//		ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
//		conversionServiceFactoryBean.setConverters(Collections.singleton(new StringToUserConverter()));
//		return conversionServiceFactoryBean;
//	}

//	@Bean
//	public CustomEditorConfigurer customEditorConfigurer(){
//		CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
//
//		Map<Class<?>, Class<? extends PropertyEditor>> customEditors = new HashMap<>();
//		customEditors.put(User.class, StringToUserPropertyEditor.class);
//
//		customEditorConfigurer.setCustomEditors(customEditors);
//		return customEditorConfigurer;
//	}

//	@Bean
//	public MessageSource messageSource(){
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasename("messages");
//		return messageSource;
//	}

//	@Bean
//	public ApplicationListener applicationListener(){
//		return new ApplicationListener(){
//			@Override
//			public void onApplicationEvent(ApplicationEvent event) {
//				System.out.println(event.getSource());
//				System.out.println("接收到了事件");
//			}
//		};
//	}

}
