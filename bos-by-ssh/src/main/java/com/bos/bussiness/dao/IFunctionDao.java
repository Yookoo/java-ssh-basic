package com.bos.bussiness.dao;

import java.util.List;

import com.bos.bussiness.dao.base.IBaseDao;
import com.bos.bussiness.domain.Function;
public interface IFunctionDao extends IBaseDao<Function>{

	public List<Function> findByUserId(String userId);

	public List<Function> findAllMenu();

	public List<Function> findMenuByUserId(String id);

}
