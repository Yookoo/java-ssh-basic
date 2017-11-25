package com.bos.bussiness.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bos.bussiness.dao.IRoleDao;
import com.bos.bussiness.domain.Function;
import com.bos.bussiness.domain.Role;
import com.bos.bussiness.service.IRoleService;
import com.bos.utils.PageBean;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService{

	@Resource
	private IRoleDao roleDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public void save(Role role, String ids) {
		
		roleDao.save(role);
		String [] functionIds = ids.split(",");
		for (String fid : functionIds) {
			Function function = new Function(fid);
			role.getFunctions().add(function);
		}
		
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		roleDao.pageQuery(pageBean);
	}

	@Override
	public List<Role> findList() {
		List<Role> list = roleDao.findAll();
		return list;
		
	}

}
