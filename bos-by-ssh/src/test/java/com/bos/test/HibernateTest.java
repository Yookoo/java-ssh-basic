package com.bos.test;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.crm.domain.Customer;

/**
 * 
 * Hibernate的测试类
 * @author ZKY
 *
 */
public class HibernateTest {
	
	@Test
	public void getHibernateSession(){
		 SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
		 Session session = factory.openSession();
		 session.close();
	}

}
