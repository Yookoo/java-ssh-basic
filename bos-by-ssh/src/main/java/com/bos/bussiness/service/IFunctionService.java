package com.bos.bussiness.service;

import java.util.List;

import com.bos.bussiness.domain.Function;
import com.bos.bussiness.domain.User;
import com.bos.utils.PageBean;

public interface IFunctionService {

	public void pageQuery(PageBean pageBean);

	public List<Function> findAll();

	public void save(Function model);

	public List<Function> findMenu();


}
