package com.bos.web.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.crm.domain.Customer;

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.bos.bussiness.domain.Decidedzone;
import com.bos.utils.PageBean;
import com.bos.web.action.base.BaseAction;
@Controller
@Scope("prototype")
public class DecidedzoneAction extends BaseAction<Decidedzone>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String [] subareaid;
	public void setSubareaid(String[] subareaid) {
		this.subareaid = subareaid;
	}
	private Integer [] customerIds;
	public void setCustomerIds(Integer[] customerIds) {
		this.customerIds = customerIds;
	}


	public String editDecidedzone(){

		decidedzoneService.editDecidedzone(model,subareaid);
		return "list";
	}
	
	public String findDecidedzoneByPage(){
		decidedzoneService.pageQuery(pageBean);
		String [] includes = new String [] {"DetachedCriteria"};
		this.objectToJson(pageBean, null,includes);
		return NONE;
	}
	
	public String findnoassociationCustomer(){
		List<Customer> list = customerService.findnoassociationCustomers();

		String [] includes = new String [] {"id","name"};
		this.arrayListToJson(list, null,includes);
		return NONE;
	}
	public String findhasassociationCustomer(){
		List<Customer> list = customerService.findhasassociationCustomers(model.getId());

		String [] includes = new String [] {"id","name"};
		this.arrayListToJson(list, null,includes);
		return NONE;
	}
	
	public String assignCustomersToDecidedzone(){
		customerService.assignCustomersToDecidedZone(customerIds, model.getId());
		return "list";
	} 
}
