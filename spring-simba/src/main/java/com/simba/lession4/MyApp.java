package com.simba.lession4;

import com.simba.lession4.service.UserService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class MyApp {
	@Bean(autowire = Autowire.BY_NAME)
	public UserService userService(){
		return new UserService();
	}

}
