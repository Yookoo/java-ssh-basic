package com.bos.web.intercepter;

import org.apache.struts2.ServletActionContext;

import com.bos.bussiness.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginIntercepter extends MethodFilterInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		
		if(user == null){
			return "login";
		}
		return invocation.invoke();
	}

}
