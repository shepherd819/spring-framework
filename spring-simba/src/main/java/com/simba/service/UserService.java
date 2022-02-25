package com.simba.service;

import com.simba.mapper.OrderMapper;
import com.simba.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component
@Scope("prototype")
public class UserService {
	@Autowired
	OrderMapper userMapper;


	public void test(){
//		System.out.println(userMapper.selectById());
//		System.out.println(b());
		System.out.println("test");
	}

	@Transactional
	public void testa() throws Exception {
		System.out.println("testa");
		throw new Exception("");
	}

}
