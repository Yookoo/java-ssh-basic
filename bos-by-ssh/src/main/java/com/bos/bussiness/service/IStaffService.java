package com.bos.bussiness.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;

import com.bos.bussiness.domain.Staff;
import com.bos.utils.PageBean;


public interface IStaffService {

	public void pageQuery(PageBean pageBean);

	public void deleteStaff(String ids);

	public void editStaff(Staff staff);

	public List<Staff> findStaffNotDelete();



}
