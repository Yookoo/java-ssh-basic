package com.bos.web.action;

import java.io.IOException;

import javax.annotation.Resource;

import org.activiti.engine.ProcessEngine;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bos.bussiness.domain.User;
import com.bos.utils.MD5Utils;
import com.bos.web.action.base.BaseAction;




/**
 * @ Controller让Spring为自动我们创建Action实例
 * @ Scope("prototype")设置action为多例
 * 
 * @author ZKY
 */
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String checkcode;
	
	
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	/**
	 * shiro的登录方法
	 * @return
	 */
	public String login() {
		//生成的验证码
		String key = (String) ServletActionContext.getRequest().getSession().getAttribute("key");

		if(StringUtils.isNotBlank(checkcode) && checkcode.equals(key)){
			//获得当前用户对象	
			Subject subject = SecurityUtils.getSubject();
			String password = model.getPassword();
			//构造用户令牌
			AuthenticationToken token = new UsernamePasswordToken(model.getUsername(),MD5Utils.md5(password));
			try {
				subject.login(token);
			} catch (UnknownAccountException e) {
				
				e.printStackTrace();
				this.addActionError(this.getText("usernamenotfoundError"));
				return "login";
			} catch (Exception e) {
				//设置错误信息
				this.addActionError(this.getText("loginError"));
				return "login";
			}
			//获取认证信息对象中存储的User对象
			User user = (User) subject.getPrincipal();
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return "home";
		}else {
			this.addActionError(this.getText("validateCodeError"));
			return "login";

		} 

	}
	
	/**
	 * 传统登录方法
	 * @return
	 */
	public String login_backup() {
		//生成的验证码
		String key = (String) ServletActionContext.getRequest().getSession().getAttribute("key");

		if(StringUtils.isNotBlank(checkcode) && checkcode.equals(key)){
				
			User user = userService.login(model);
			if(user != null){
				ServletActionContext.getRequest().getSession().setAttribute("user",user);
				return "home";
			}else{
				this.addActionError(this.getText("loginError"));
			}
		}else{
			this.addActionError(this.getText("validateCodeError"));
		}
		return "login";

	}
	
	
	public String logout(){
		//清除Session
		ServletActionContext.getRequest().getSession().invalidate();
		return "login";
	}
	
	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public String editPassword () throws IOException{
		
		User user=(User)ServletActionContext.getRequest().getSession().getAttribute("user");

		String password = MD5Utils.md5(model.getPassword());
		
		int flag = 0;
		try {
			userService.editPassword(password,user.getId());	
			flag = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(flag);
		
		return NONE;
	}

	public String pageQuery(){
		userService.pageQuery(pageBean);
		String [] excludes = new String []{"noticebills","roles","detachedCriteria"};
		this.objectToJson(pageBean, excludes, null);
		return NONE;
	}
	
	/**
	 * 对于功能权限的添加方法
	 * @param 无
	 * @author ZKY
	 * @category 方法
	 * @return String
	 */
	private String [] roleIds;
	
	public String[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}

	public String add(){
		userService.save(model,roleIds);
		return "list";
		
	}
}
