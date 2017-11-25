package com.bos.bussiness.service;

import com.bos.bussiness.domain.Decidedzone;
import com.bos.utils.PageBean;

public interface IDecidedzoneService {

	public void editDecidedzone(Decidedzone model,String [] subareaid);

	public void pageQuery(PageBean pageBean);

	public Decidedzone findDecidedZoneById(String decidedZoneId);

}
