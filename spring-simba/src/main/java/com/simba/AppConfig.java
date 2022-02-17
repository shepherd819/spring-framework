package com.simba;

import com.simba.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@ComponentScan
@Configuration
@EnableAspectJAutoProxy
@Component
public class AppConfig {

//	public AppConfig(MyConfig myConfig){
//
//	}

//	@Bean("b")
//	public OrderService orderService(){
//		return new OrderService();
//	}


}
