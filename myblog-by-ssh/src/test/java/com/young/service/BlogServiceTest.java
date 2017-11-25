package com.young.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.young.po.Blog;

public class BlogServiceTest {
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
	public void testFindById() {
		BlogService blogService = ctx.getBean(BlogService.class);
		Blog blog = blogService.findById(1);
		System.out.println(blog.getDescription());
		
	}

}
