package com.bos.bussiness.service.impl;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.sevice.CustomerService;

import com.bos.bussiness.dao.INoticebillDao;
import com.bos.bussiness.dao.IWorkbillDao;

import com.bos.bussiness.domain.Decidedzone;
import com.bos.bussiness.domain.Noticebill;
import com.bos.bussiness.domain.Staff;
import com.bos.bussiness.domain.Workbill;
import com.bos.bussiness.service.IDecidedzoneService;
import com.bos.bussiness.service.INoticebillService;
import com.bos.utils.PageBean;

@Service
@Transactional
public class NoticebillServiceImpl implements INoticebillService{

	@Resource
	private INoticebillDao noticebillDao;
	
	@Resource
	private IWorkbillDao workbillDao;
	
	@Resource
	private CustomerService customerService;
	@Resource
	private IDecidedzoneService decidedzoneService;
	
	@Override
	public void save(Noticebill noticebill) {
		// TODO Auto-generated method stub
		noticebillDao.save(noticebill);
		String address = noticebill.getPickaddress();
		//根据取件地址查询定区ID
		String decidedZoneId = customerService.finddecidedZoneIdByAddress(address);
		if(decidedZoneId != null){
			//自动分单
			Decidedzone decidedzone = decidedzoneService.findDecidedZoneById(decidedZoneId);
			Staff staff = decidedzone.getStaff();
			noticebill.setStaff(staff);
			noticebill.setOrdertype("自动");
			//为取派员创建工单
			Workbill workbill =  new Workbill();
			workbill.setNoticebill(noticebill);
			workbill.setAttachbilltimes(0);//追单次数
 
			workbill.setBuildtime(new Date().toLocaleString());
			workbill.setPickstate("未取件");
			workbill.setRemark(noticebill.getRemark());
			workbill.setStaff(staff);
			workbill.setType("新单");
			workbillDao.save(workbill);
			
			//调用短信平台给取派员发短信通知
			
		}else {
			//创建人工分单任务
			noticebill.setOrdertype("人工");
	
		}
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		noticebillDao.pageQuery(pageBean);
	}

	@Override
	public void savenoassociations(Noticebill noticebill) {
		Staff staff = noticebill.getStaff();
		noticebill = noticebillDao.findById(noticebill.getId());
		noticebill.setStaff(staff);
		noticebillDao.saveOrUpdate(noticebill);
		//为取派员创建工单
		Workbill workbill =  new Workbill();
		workbill.setNoticebill(noticebill);
		workbill.setAttachbilltimes(0);//追单次数
		workbill.setBuildtime(new Date().toLocaleString());
		workbill.setPickstate("未取件");
		workbill.setRemark(noticebill.getRemark());
		workbill.setStaff(staff);
		workbill.setType("新单");
		workbillDao.save(workbill);
		
		//调用短信平台给取派员发短信通知
	}
}
