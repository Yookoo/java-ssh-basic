package com.bos.bussiness.service;

import java.util.List;

import com.bos.bussiness.domain.Subarea;
import com.bos.utils.PageBean;

public interface ISubareaService {

	public void editSubarea(Subarea subarea);

	public void findSubarea(PageBean pageBean);

	public List<Subarea> findAll();

	public List<Subarea> findSubareaNotAssociation();

}
