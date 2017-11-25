package com.young.service;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.young.dao.UserDao;
import com.young.po.User;
@Transactional
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	@Override
	public User signup(User user) {

		try {
			
			User tmp = userDao.findByUsername(user.getUsername());
			
			// 如果user已存在直接返回null
			if(tmp != null )  return null;			
			
			userDao.save(user);
			/**
			 * 
			 */
			user = userDao.findByUsername(user.getUsername());
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return user;
	}
	@Override
	public User login(User user) {
		User tmp;
		try {
			
			tmp = userDao.findByUsername(user.getUsername());
			
			// 如果user不存在直接返回null
			if(tmp == null )  return null;			

			if(!tmp.getPassword().equals(user.getPassword())) return null; 
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
		return tmp;
	}
	
	public String logout(){
		//清除Session
		ServletActionContext.getRequest().getSession().invalidate();
		return "login";
	}
	

}
