package com.bos.bussiness.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bos.bussiness.dao.IWorkordermanageDao;
import com.bos.bussiness.domain.Workordermanage;
import com.bos.bussiness.service.IWorkordermanageService;
import com.bos.utils.PageBean;
@Service
@Transactional
public class WorkordermanageServiceImpl implements IWorkordermanageService{

	@Resource
	private IWorkordermanageDao workordermanageDao;
	
	@Override
	public void save(Workordermanage workordermanage) {
		// TODO Auto-generated method stub
		workordermanage.setUpdatetime(new Date().toLocaleString());
		workordermanageDao.save(workordermanage);
	}

	@Override
	public void findWorkordermanage(PageBean pageBean) {
		// TODO Auto-generated method stub
		workordermanageDao.pageQuery(pageBean);
	}

}
