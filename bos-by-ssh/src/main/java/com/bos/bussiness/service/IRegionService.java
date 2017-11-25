package com.bos.bussiness.service;

import java.util.List;

import com.bos.bussiness.domain.Region;
import com.bos.utils.PageBean;

public interface IRegionService {

	public void saveBatch(List<Region> list);

	public void pageQuery(PageBean pageBean);

	public List<Region> findAll();

}
