package com.bos.bussiness.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bos.bussiness.dao.IFunctionDao;
import com.bos.bussiness.dao.base.impl.BaseDaoImpl;
import com.bos.bussiness.domain.Function;

@Repository
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements IFunctionDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Function> findByUserId(String userId) {

		String hql = "SELECT DISTINCT f FROM Function f LEFT OUTER JOIN f.roles r " +
				"LEFT OUTER JOIN r.users u WHERE u.id = ?";
		
		return this.getHibernateTemplate().find(hql,userId);
	}

	@Override
	public List<Function> findAllMenu() {
		String hql = "FROM Function f WHERE f.generatemenu = '1' ORDER BY f.zindex ASC ";		
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public List<Function> findMenuByUserId(String id) {
		String hql = "SELECT DISTINCT f FROM Function f LEFT OUTER JOIN f.roles r " +
				"LEFT OUTER JOIN r.users u WHERE u.id = ? AND f.generatemenu = '1' ORDER BY f.zindex ASC";
		return this.getHibernateTemplate().find(hql,id);
	}
	
	

}
