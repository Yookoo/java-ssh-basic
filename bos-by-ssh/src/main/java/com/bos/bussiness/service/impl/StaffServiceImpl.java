package com.bos.bussiness.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bos.bussiness.dao.IStaffDao;
import com.bos.bussiness.domain.Staff;
import com.bos.bussiness.service.IStaffService;
import com.bos.bussiness.service.base.impl.BaseServiceImpl;
import com.bos.utils.PageBean;

@Transactional
@Service
public class StaffServiceImpl implements IStaffService {
	
	@Autowired
	private IStaffDao staffDao;

	@Override
	public void editStaff(Staff staff) {
		// TODO Auto-generated method stub
		staffDao.saveOrUpdate(staff);
	}


	@Override
	public void deleteStaff(String ids) {
		
		String queryName = "deleteStaff";
	
		staffDao.executeUpdate(queryName, ids);
	


	}

	@Override
	public List<Staff> findStaffNotDelete() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Staff.class);
		criteria.add(Restrictions.eq("deltag", "0"));
		List<Staff> list = staffDao.findByCriteria(criteria);
		return list;
	}


	@Override
	public void pageQuery(PageBean pageBean) {
		staffDao.pageQuery(pageBean);
	}
}
