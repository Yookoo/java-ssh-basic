package com.bos.shiro;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.bos.bussiness.dao.IFunctionDao;
import com.bos.bussiness.dao.IUserDao;
import com.bos.bussiness.domain.Function;
import com.bos.bussiness.domain.User;
import com.bos.bussiness.service.IFunctionService;

public class BOSRealm extends AuthorizingRealm{
	
	@Resource
	private IUserDao userDao;
	@Resource
	private IFunctionDao functionDao;
	/**
	 * 授权方法
	 * 
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection collection) {
		User user = (User)collection.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		List<Function> list  = null;
		if(user.getUsername().equals("admin")){
			list = functionDao.findAll();
		} else {	
			list = functionDao.findByUserId(user.getId());
		}
		for (Function function : list) {
			info.addStringPermission(function.getCode());//添加权限
		}
		//info.addRole("staff");//添加staff角色
		return info;
	}
	/*
	 * 认证方法
	 * 
	 */

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		//
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();// 从令牌中获得用户名

		User user = userDao.findUserByUsername(username);
		if (user == null) {
			// 用户名不存在
			return null;
		} else {
			// 用户名存在
			String password = user.getPassword();// 获得数据库中存储的密码
			// 创建简单认证信息对象
			/***
			 * 参数一：签名，程序可以在任意位置获取当前放入的对象
			 * 参数二：从数据库中查询出的密码
			 * 参数三：当前realm的名称
			 */
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,
					password, this.getClass().getSimpleName());
			return info;//返回给安全管理器，由安全管理器负责比对数据库中查询出的密码和页面提交的密码
		}

	}

}
