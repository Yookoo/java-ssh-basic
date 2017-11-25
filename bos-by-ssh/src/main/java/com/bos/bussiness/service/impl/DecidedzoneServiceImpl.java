package com.bos.bussiness.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bos.bussiness.dao.IDecidedzoneDao;
import com.bos.bussiness.dao.ISubareaDao;
import com.bos.bussiness.domain.Decidedzone;
import com.bos.bussiness.domain.Subarea;
import com.bos.bussiness.service.IDecidedzoneService;
import com.bos.utils.PageBean;
@Service
@Transactional
public class DecidedzoneServiceImpl implements IDecidedzoneService {

	@Autowired
	private IDecidedzoneDao decidedzoneDao;
	@Autowired
	private ISubareaDao subareaDao;

	@Override
	public void editDecidedzone(Decidedzone model, String[] subareaid) {
		decidedzoneDao.saveOrUpdate(model);
		
		for (String id : subareaid) {
			Subarea subarea = subareaDao.findById(id);
			subarea.setDecidedzone(model);
		}
		
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		decidedzoneDao.pageQuery(pageBean);
		
	}

	@Override
	public Decidedzone findDecidedZoneById(String decidedZoneId) {
		// TODO Auto-generated method stub
		Decidedzone decidedzone = decidedzoneDao.findById(decidedZoneId);
		return decidedzone;
	}

}
