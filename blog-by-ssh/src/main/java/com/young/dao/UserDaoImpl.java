package com.young.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.young.po.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@SuppressWarnings("unchecked")
	@Override
	public User findByUsername(String username) {

		List<User> users= this.getHibernateTemplate().find("from User where username = ?", username);
		if (users != null && users.size() > 0) {
			
			return users.get(0);
		} else {
			return null;
		}
		
	}

}
