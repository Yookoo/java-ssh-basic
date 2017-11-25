package com.bos.bussiness.service;

import java.util.List;

import com.bos.bussiness.domain.Role;
import com.bos.utils.PageBean;

public interface IRoleService {
	public void save(Role role,String ids);

	public void pageQuery(PageBean pageBean);

	public List<Role> findList();
}
