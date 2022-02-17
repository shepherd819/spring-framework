package com.simba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AService {
	@Autowired
	private BService bService;

	public void test(){
		System.out.println(bService);
	}
	@Autowired
	@Qualifier("BService")
	public void b(BService BService){

	}
}
