package com.huangxi.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

//循环依赖测试
public class BoyFriend {
	@Autowired
	private GirlFriend girlFriend;
}
