package com.bos.bussiness.dao;

import com.bos.bussiness.dao.base.IBaseDao;
import com.bos.bussiness.domain.User;

public interface IUserDao extends IBaseDao<User>{
	
	public User findUserByUsernameAndPassword(String username,String password);

	public User findUserByUsername(String username);

}
