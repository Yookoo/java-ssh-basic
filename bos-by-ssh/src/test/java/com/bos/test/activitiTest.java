package com.bos.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class activitiTest {
	ApplicationContext ac = new ClassPathXmlApplicationContext("activiti-context.xml");
	ProcessEngine processEngine = (ProcessEngine) ac.getBean("processEngine");
	@Test
	public void test01(){
		List<Deployment> list = processEngine.getRepositoryService().createDeploymentQuery().list();
		for (Deployment deployment : list) {
			System.out.println(deployment);
		}
	}
	@Test
	public void test02() throws FileNotFoundException{
		DeploymentBuilder deploymentBuilder = processEngine.getRepositoryService().createDeployment();
		deploymentBuilder.addZipInputStream(new ZipInputStream(new FileInputStream(new File("process\\process.zip"))));
		deploymentBuilder.deploy();

	}

}
