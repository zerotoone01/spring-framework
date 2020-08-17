package com.huangxi.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

//循环依赖测试

/**
 *  setter方式注入
 * @see AbstractAutowireCapableBeanFactory#doCreateBean(java.lang.String, org.springframework.beans.factory.support.RootBeanDefinition, java.lang.Object[])
 */
@Repository
//@Scope("prototype") Spring不支持prototype
public class BoyFriend {
	@Autowired
	private GirlFriend girlFriend;
}
