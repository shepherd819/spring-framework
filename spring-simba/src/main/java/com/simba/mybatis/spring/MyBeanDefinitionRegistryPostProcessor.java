package com.simba.mybatis.spring;

import com.simba.mapper.OrderMapper;
import com.simba.mapper.UserMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

//@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		beanDefinition.setBeanClass(MapperFactoryBean.class);
		beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(UserMapper.class);
		registry.registerBeanDefinition("userMapper", beanDefinition);
		AbstractBeanDefinition beanDefinition1 = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		beanDefinition1.setBeanClass(MapperFactoryBean.class);
		beanDefinition1.getConstructorArgumentValues().addGenericArgumentValue(OrderMapper.class);
		registry.registerBeanDefinition("orderMapper", beanDefinition1);
	}
}
