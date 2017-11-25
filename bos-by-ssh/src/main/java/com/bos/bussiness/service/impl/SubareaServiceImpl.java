package com.bos.bussiness.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bos.bussiness.dao.ISubareaDao;
import com.bos.bussiness.domain.Subarea;
import com.bos.bussiness.service.ISubareaService;
import com.bos.utils.PageBean;

@Service
@Transactional
public class SubareaServiceImpl implements ISubareaService {
	
	@Autowired
	private ISubareaDao subareaDao;

	@Override
	public void editSubarea(Subarea subarea) {

		subareaDao.saveOrUpdate(subarea);
	}

	@Override
	public void findSubarea(PageBean pageBean) {

		subareaDao.pageQuery(pageBean);
	}

	@Override
	public List<Subarea> findAll() {
		
		List<Subarea> list = subareaDao.findAll();
		return list;
	}

	@Override
	public List<Subarea> findSubareaNotAssociation() {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Subarea.class);
		criteria.add(Restrictions.isNull("decidedzone"));
		List<Subarea> list = subareaDao.findByCriteria(criteria);
		return list;
	}

}
