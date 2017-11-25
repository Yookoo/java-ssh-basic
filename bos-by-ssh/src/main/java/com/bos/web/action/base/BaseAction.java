package com.bos.web.action.base;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.crm.sevice.CustomerService;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.bos.bussiness.domain.Region;
import com.bos.bussiness.service.IDecidedzoneService;
import com.bos.bussiness.service.IFunctionService;
import com.bos.bussiness.service.INoticebillService;
import com.bos.bussiness.service.IRegionService;
import com.bos.bussiness.service.IRoleService;
import com.bos.bussiness.service.IStaffService;
import com.bos.bussiness.service.ISubareaService;
import com.bos.bussiness.service.IUserService;
import com.bos.bussiness.service.IWorkordermanageService;
import com.bos.utils.PageBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	protected IFunctionService functionService;
	@Resource
	protected CustomerService customerService;
	@Resource
	protected ISubareaService subareaService;
	@Resource
	protected IDecidedzoneService decidedzoneService;
	@Resource
	protected IRegionService regionService;
	
	@Resource
	protected IStaffService staffService;

	@Resource
	protected IUserService userService;
	
	@Resource
	protected INoticebillService noticebillService;
	
	@Resource
	protected IWorkordermanageService workordermanageService;
	
	@Resource
	protected IRoleService roleService;
	
	protected PageBean pageBean = new PageBean();
	
	public void setPage(int page) {
		pageBean.setCurrentPage(page);
	}

	public void setRows(int rows) {
		pageBean.setPageSize(rows);
	}


	protected void objectToJson(Object object, String [] excludes, String [] includes) {
		
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
		if(excludes !=null && excludes.length > 0){
			filter.getExcludes().addAll(new HashSet<String>(Arrays.asList(excludes)));
		}
		
		if(includes !=null && includes.length > 0){
			filter.getIncludes().addAll(new HashSet<String>(Arrays.asList(includes)));
		}
		
		String jsonString = JSONObject.toJSONString(object,filter);
		
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		try {
			ServletActionContext.getResponse().getWriter().print(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void arrayListToJson(List list, String [] excludes, String [] includes) {
		
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
		if(excludes !=null && excludes.length > 0){
			filter.getExcludes().addAll(new HashSet<String>(Arrays.asList(excludes)));
		}
		
		if(includes !=null && includes.length > 0){
			filter.getIncludes().addAll(new HashSet<String>(Arrays.asList(includes)));
		}
		
		String jsonString = JSONArray.toJSONString(list,filter);
		
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		try {
			ServletActionContext.getResponse().getWriter().print(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
			pageBean.setDetachedCriteria(DetachedCriteria.forClass(type));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	

}
