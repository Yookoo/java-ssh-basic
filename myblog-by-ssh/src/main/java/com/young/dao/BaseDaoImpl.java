package com.young.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.young.util.PageBean;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class<T> entityClass;
	
	/*
	 * 通过注解获得SessionFactory将其传给父类可以得到getHibernateTemplate模版对象
	 */
	/*
	 * spring提供
	 * Autowired按照类型注入
	 * Qualifier(value="abc")按照名称注入
	 */
	//@Autowired
	//@Qualifier(value="abc")
	//按照名称或类型注入，默认是类型（jdk1.5提供�?
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	/*
	 * 通过构造方法动态的获得泛型的类T
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		//获得父类BaseDaoImpl<T>的类�?
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		ParameterizedType type =null;
		if(genericSuperclass instanceof ParameterizedType){
			type =(ParameterizedType)genericSuperclass;
		} else {
			type =(ParameterizedType)this.getClass().getSuperclass().getGenericSuperclass();
		}
		
		//获得父类的泛型数�?
		Type[] actualTypeArguments = type.getActualTypeArguments();
		
		entityClass = (Class<T>) actualTypeArguments[0];
		
		//System.out.println("entityClass已经初始�?");
	}

	@Override
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}
	@Override
	public void saveOrUpdate(T entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
	}
	@Override
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}

	@Override
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
	}

	@Override
	public T findById(Serializable id) {
		return this.getHibernateTemplate().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		String hql ="FROM "+entityClass.getSimpleName();
		return this.getHibernateTemplate().find(hql);
	}
	
	/**
	 * 通用的分页查询
	 */	
	@SuppressWarnings("unchecked")
	public void pageQuery(PageBean<T> pageBean) {
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
		//1.查询数据总量  需要把查询语句改编为 select count(*) from 形式 
		detachedCriteria.setProjection(Projections.rowCount());
		
		List<Long> rowCount = this.getHibernateTemplate().findByCriteria(detachedCriteria);
		
		if(rowCount != null && rowCount.size() ==1){
			pageBean.setTotalCount(rowCount.get(0).intValue());
		}
		
		//2.查询分页数据  
		//先将查询方式设置为默认
		detachedCriteria.setProjection(null);
		//重置表和类的映射关系
		detachedCriteria.setResultTransformer(DetachedCriteria.ROOT_ENTITY);
		//设置需要查询的数据
		int currentPage = pageBean.getCurrentPage();
		int pageSize = pageBean.getPageSize();	
		int firstResult = (currentPage-1) * pageSize;
		int maxResults = pageSize;
		//指定查询条件
		List<T> list = this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResults);
		pageBean.setList(list);;
	}
	
	@Override
	public List<T> findByCriteria(DetachedCriteria criteria) {

		@SuppressWarnings("unchecked")
		List<T> list = this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}
}
