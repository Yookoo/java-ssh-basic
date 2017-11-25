package com.young.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.young.util.PageBean;

/**
 * 
 * 基础的持久层操作
 * @author ZKY
 *
 * @param <T>
 */
public interface BaseDao<T> {
	/**
	 * 保存
	 * @param entity
	 */
	public void save(T entity);
	
	/**
	 * 更新
	 * @param entity
	 */
	public void update(T entity);
	/**
	 * 删除
	 * @param entity
	 */
	
	public void delete(T entity);
	/**
	 * 查询一个
	 * @param id
	 */
	public T findById(Serializable id);
	/**
	 * 查询所有
	 * @return list
	 */

	public List<T> findAll();
	
	/**
	 * 保存或更新
	 * @param entity
	 */
	public void saveOrUpdate(T entity);
	/**
	 * 分页查询
	 * @param pageBean
	 */
	public void pageQuery(PageBean<T> pageBean);
	/**
	 * 根据条件查询
	 * @param criteria
	 */
	List<T> findByCriteria(DetachedCriteria criteria);

}
