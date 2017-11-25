package com.bos.bussiness.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.bos.bussiness.dao.IUserDao;
import com.bos.bussiness.dao.base.impl.BaseDaoImpl;
import com.bos.bussiness.domain.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

	@Override
	public User findUserByUsernameAndPassword(String username,String password) {
		String hql = "FROM User u WHERE u.username = ? AND u.password = ?";
		@SuppressWarnings("unchecked")
		List<User> userList = this.getHibernateTemplate().find(hql,username,password);
		if(userList != null && userList.size() == 1){
			return userList.get(0);
		}
		return null;
	}

	@Override
	public User findUserByUsername(String username) {
		String hql = "FROM User u WHERE u.username = ?";
		@SuppressWarnings("unchecked")
		List<User> userList = this.getHibernateTemplate().find(hql,username);
		if(userList != null && userList.size() == 1){
			return userList.get(0);
		}
		return null;
	}

}
