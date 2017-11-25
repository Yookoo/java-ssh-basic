package com.bos.bussiness.service.base.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bos.bussiness.dao.base.IBaseDao;
import com.bos.bussiness.dao.base.impl.BaseDaoImpl;
import com.bos.bussiness.service.base.IBaseService;
import com.bos.utils.PageBean;
/**
 * 暂未完成，等待优化
 * @author ZKY
 *
 * @param <T>
 */

public class BaseServiceImpl<T> implements IBaseService<T>{

	private Class<T> entityClass;
	

	private IBaseDao<T> baseDao;
	/*
	 * 通过构造方法动态的获得泛型的类型
	 */
	@SuppressWarnings("unchecked")
	public BaseServiceImpl() {
		//获得父类BaseServiceImpl<T>的类型
		ParameterizedType genericSuperclass = (ParameterizedType)this.getClass().getGenericSuperclass();
		
		ParameterizedType type =null;
		if(genericSuperclass instanceof ParameterizedType){
			type =(ParameterizedType)genericSuperclass;
		} else {
			type =(ParameterizedType)this.getClass().getSuperclass().getGenericSuperclass();
		}
		//获得父类的泛型数组
		Type[] actualTypeArguments = type.getActualTypeArguments();
		entityClass = (Class<T>) actualTypeArguments[0];
		
		//baseDao = new BaseDaoImpl<entityClass.>();
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		baseDao.pageQuery(pageBean);		
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
