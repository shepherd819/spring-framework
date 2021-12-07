package com.simba.lession4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BService {
	@Autowired
	private AService aService;
}
