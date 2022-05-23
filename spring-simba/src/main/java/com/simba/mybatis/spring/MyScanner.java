package com.simba.mybatis.spring;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;

import java.util.Set;

public class MyScanner extends ClassPathBeanDefinitionScanner {
	public MyScanner(BeanDefinitionRegistry registry) {
		super(registry);
	}

	public MyScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters) {
		super(registry, useDefaultFilters);
	}

	public MyScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters, Environment environment) {
		super(registry, useDefaultFilters, environment);
	}

	public MyScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters, Environment environment, ResourceLoader resourceLoader) {
		super(registry, useDefaultFilters, environment, resourceLoader);
	}

	@Override
	protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
		return true;
	}

	@Override
	protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
		return super.doScan(basePackages);
	}
}
