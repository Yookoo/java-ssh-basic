package com.bos.bussiness.service;

import java.util.List;

import com.bos.bussiness.domain.Workordermanage;
import com.bos.utils.PageBean;

public interface IWorkordermanageService {

	public void save(Workordermanage workordermanage);


	public void findWorkordermanage(PageBean pageBean);

	
}
