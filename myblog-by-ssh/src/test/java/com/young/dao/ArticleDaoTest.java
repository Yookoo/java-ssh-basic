package com.young.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.young.po.Article;

public class ArticleDaoTest {
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
		 ArticleDao  articleDao = ctx.getBean( ArticleDao.class);
		
		 Article article = articleDao.findById(25);
		 System.out.println(article);
	}

}
