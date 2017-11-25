package com.bos.bussiness.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bos.bussiness.dao.IUserDao;
import com.bos.bussiness.domain.Role;
import com.bos.bussiness.domain.User;
import com.bos.bussiness.service.IUserService;
import com.bos.utils.MD5Utils;
import com.bos.utils.PageBean;


@Transactional
@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDao userDao;

	@Override
	public User login(User user) {
		
		String username = user.getUsername();
		String password = MD5Utils.md5(user.getPassword());
		
		return userDao.findUserByUsernameAndPassword(username, password);

	}

	@Override
	public void editPassword(String password,String id) {
		
		String queryName = "editPassword";
		
		userDao.executeUpdate(queryName,password,id);
		
		
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		userDao.pageQuery(pageBean);	
	}

	@Override
	public void save(User user, String[] roleIds) {
		
		String password = MD5Utils.md5(user.getPassword());
		user.setPassword(password);
		userDao.save(user);
		
		for (String roleId : roleIds) {
			Role role = new Role(roleId);
			user.getRoles().add(role);
		}
	}

}
