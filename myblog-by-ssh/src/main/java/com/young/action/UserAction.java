package com.young.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.young.po.User;
import com.young.util.DateFormatUtils;
import com.young.util.MD5Utils;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3830096023170240521L;


	/**
	 * 注册方法
	 * @return
	 */
	public String signup() {
		if(!(model!=null && model.getPassword().equals(repassword))) return ERROR;
		try {

			model.setNickname(model.getUsername());
			model.setPassword(MD5Utils.md5(model.getPassword()));
			model.setJointime(DateFormatUtils.toyyyyMMddHHmmss(new Date()));
			model.setFlag(1); //可用状态
			User user= userService.signup(model);
			if(user == null) return ERROR;
			/**
			 * 注册完成之后直接登录
			 */
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	} 
	/**
	 * 登录方法
	 * @return
	 */
	public String login() {

		try {
			model.setPassword(MD5Utils.md5(model.getPassword()));
			User user = userService.login(model);
			if(user == null) return ERROR;
			/**
			 * 登录成功将user放入session
			 */
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	} 
	
	public String logout(){
		//清除Session
		ServletActionContext.getRequest().getSession().invalidate();
		return "index";
	}
	
	
	private String repassword ; 
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
}
