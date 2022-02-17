package com.simba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


public class MyConfig {
	@Autowired
	public MyConfig(AppConfig appConfig){
		System.out.println(appConfig);
	}
}
