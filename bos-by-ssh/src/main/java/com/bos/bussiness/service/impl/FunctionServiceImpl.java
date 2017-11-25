package com.bos.bussiness.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bos.bussiness.dao.IFunctionDao;
import com.bos.bussiness.domain.Function;
import com.bos.bussiness.domain.User;
import com.bos.bussiness.service.IFunctionService;
import com.bos.utils.PageBean;
import org.apache.struts2.ServletActionContext;
/**
 * FunctionService的实现类
 * @author ZKY
 *
 */

@Service
@Transactional
public class FunctionServiceImpl implements IFunctionService{
	@Autowired
	private IFunctionDao functionDao;
	
	@Override
	public void pageQuery(PageBean pageBean) {
		functionDao.pageQuery(pageBean);		
	}
	/**
	 * 查询所有的function
	 * @author ZKY
	 * @return List<Function>
	 */
	@Override
	public List<Function> findAll() {
		
		return functionDao.findAll();
	}
	/**
	 * 保存function,若function的父function的id为空串,需要将function设置为null,否则会报外键问题;
	 * @author ZKY
	 * @param Function
	 */
	@Override
	public void save(Function function) {
		if(function != null && function.getFunction() != null && function.getFunction().getId().equals("")){
			function.setFunction(null);
		}
		functionDao.save(function);
	}
	@Override
	public List<Function> findMenu() {
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("user");
		List<Function> list;
		if(user.getUsername().equals("admin")){
			list= functionDao.findAllMenu();
		} else {
			list = functionDao.findMenuByUserId(user.getId());
		}
		return list;
	}


}
