package com.bos.bussiness.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bos.bussiness.dao.IRegionDao;
import com.bos.bussiness.domain.Region;
import com.bos.bussiness.domain.Staff;
import com.bos.bussiness.service.IRegionService;
import com.bos.utils.PageBean;

@Transactional
@Service
public class RegionServiceImpl implements IRegionService{
	
	@Autowired
	private IRegionDao regionDao;
	@Override
	public void saveBatch(List<Region> list) {
		
		for (Region region : list) {
			regionDao.saveOrUpdate(region);
		}
	
	}
	@Override
	public void pageQuery(PageBean pageBean) {
		//设置查询条件
		
		regionDao.pageQuery(pageBean);
		
	}
	@Override
	public List<Region> findAll() {
		List<Region> list = regionDao.findAll();
		return list;
	}

}
