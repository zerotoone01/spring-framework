package com.huangxi.service.impl;

import com.huangxi.service.WelcomeService;

/**
 * @description TODO
 * @date 2020-07-20
 */
public class WelcomeServiceImpl implements WelcomeService {
	@Override
	public String sayHello(String name) {
		System.out.println("welcome: "+name);
		return null;
	}
}
