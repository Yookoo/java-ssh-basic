package com.bos.bussiness.service;

import java.util.List;

import com.bos.bussiness.domain.Noticebill;
import com.bos.utils.PageBean;

public interface INoticebillService {

	public void save(Noticebill noticebill);

	public void pageQuery(PageBean pageBean);

	public void savenoassociations(Noticebill noticebill);
}
