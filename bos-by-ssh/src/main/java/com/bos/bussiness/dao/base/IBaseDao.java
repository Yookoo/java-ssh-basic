package com.bos.bussiness.dao.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;

import com.bos.utils.PageBean;

public interface IBaseDao<T> {

	public void save(T entity);
	public void update(T entity);
	public void delete(T entity);
	public T findById(Serializable id);
	public List<T> findAll();
	public void executeUpdate(String queryName, Object ...objects);
	public void pageQuery(PageBean pageBean);
	public void saveOrUpdate(T entity);
	
	public List<T> findByCriteria(DetachedCriteria criteria);

}
