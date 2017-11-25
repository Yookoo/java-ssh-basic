package com.young.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.young.po.User;
import com.young.util.MD5Utils;

public class UserDaoTest {

	
	ApplicationContext ctx = null;
	
	@Before
	public void setup(){
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@After
	public void release(){
		ctx = null;
	}
	
	@Test
	public void testSave(){
		UserDao userDao = ctx.getBean(UserDao.class);
		User user =new User();
		user.setUsername("yangfan");
		user.setPassword(MD5Utils.md5("123"));
		user.setNickname("yangfan");
		//userDao.save(user);
	
	}
}
