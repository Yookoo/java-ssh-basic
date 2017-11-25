package com.bos.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class ProcessDefinitionAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private ProcessEngine processEngine;
	@Autowired
	private RepositoryService repositoryService;
	
	public String list(){
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().latestVersion().orderByProcessDefinitionName().desc().list();
		ActionContext.getContext().getValueStack().set("list", list);
		return "list";
	}
	
	private File zipFile;
	public void setZipFile(File zipFile) {
		this.zipFile = zipFile;
	}
	
	public String deploy () throws FileNotFoundException {
		DeploymentBuilder deploymentBuilder = processEngine.getRepositoryService().createDeployment();
		deploymentBuilder.addZipInputStream(new ZipInputStream(new FileInputStream(new File("process\\process.zip"))));
		deploymentBuilder.deploy();
		return "toList";		
	}
	
}
