package com.bos.bussiness.service.base;

import java.util.List;

import com.bos.utils.PageBean;

public interface IBaseService<T> {

	public void pageQuery(PageBean pageBean);
	
	public List<T> findAll() ;
}
