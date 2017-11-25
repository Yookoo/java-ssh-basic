package com.young.action;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.young.service.ArticleService;
import com.young.service.BlogService;
import com.young.service.UserService;
import com.young.util.PageBean;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	protected UserService userService;
	@Resource
	protected ArticleService articleService;
	@Resource
	protected BlogService blogService;
	/*	@Resource
	protected ArticletypeService articletypeService;
	@Resource
	protected CommentService commentService;
*/
	
	protected PageBean<T> pageBean = new PageBean<T>();
	
	public void setPage(int page) {
		pageBean.setCurrentPage(page);
	}

	public void setRows(int rows) {
		pageBean.setPageSize(rows);
	}

	protected T model;
	
	@Override
	public T getModel() {
		return model;
	}

	public BaseAction() {
		//在构造函数中动态实例化泛型T
		ParameterizedType genericSuperclass = null;
		if(this.getClass().getGenericSuperclass() instanceof ParameterizedType){
			genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();		
		} else {
			genericSuperclass = (ParameterizedType) this.getClass().getSuperclass().getGenericSuperclass();
		}			
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		@SuppressWarnings("unchecked")
		Class<T> type = (Class<T>) actualTypeArguments[0];
		try {
			model = type.newInstance();
//			pageBean.setDetachedCriteria(DetachedCriteria.forClass(type));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	

}
