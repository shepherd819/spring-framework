package com.simba.mybatis.spring;

import com.simba.mapper.OrderMapper;
import com.simba.mapper.UserMapper;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class MapperBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		Map<String, Object> allAnnotationAttributes = importingClassMetadata.getAnnotationAttributes(SimbaMapperScan.class.getName());
		String path = (String) allAnnotationAttributes.get("value");
		System.out.println("path = " + path);
		MyScanner myScanner = new MyScanner(registry);
		myScanner.addIncludeFilter(new TypeFilter() {
			@Override
			public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
				return metadataReader.getClassMetadata().isInterface();
			}
		});
		Set<BeanDefinitionHolder> beanDefinitionHolders = myScanner.doScan(path);
		for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitionHolders) {
			BeanDefinition beanDefinition = beanDefinitionHolder.getBeanDefinition();
			beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
			beanDefinition.setBeanClassName(MapperFactoryBean.class.getName());
		}

//		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//		beanDefinition.setBeanClass(MapperFactoryBean.class);
//		beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(UserMapper.class);
//		registry.registerBeanDefinition("userMapper", beanDefinition);
//		AbstractBeanDefinition beanDefinition1 = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//		beanDefinition1.setBeanClass(MapperFactoryBean.class);
//		beanDefinition1.getConstructorArgumentValues().addGenericArgumentValue(OrderMapper.class);
//		registry.registerBeanDefinition("orderMapper", beanDefinition1);
	}
}
