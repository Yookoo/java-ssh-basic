package com.young.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.young.po.User;
import com.young.util.MD5Utils;


/**
 * UserService的测试类
 * @author ZKY
 *
 */
public class UserServiceTest {
	
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
	public void testRegister(){
		UserService userService = ctx.getBean(UserService.class);
		User user =new User();
		user.setUsername("yangfan01");
		user.setPassword(MD5Utils.md5("123"));
		user.setNickname("yangfan");
		User registerUser = userService.signup(user);
		//Assert.assertNotNull(registerUser);
	}
}
