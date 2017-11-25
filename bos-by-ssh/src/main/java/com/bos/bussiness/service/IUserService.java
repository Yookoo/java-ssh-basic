package com.bos.bussiness.service;

import com.bos.bussiness.domain.User;
import com.bos.utils.PageBean;

public interface IUserService {

	public User login(User user);

	public void editPassword(String password,String id);

	public void pageQuery(PageBean pageBean);

	public void save(User model, String[] roleIds);

}
