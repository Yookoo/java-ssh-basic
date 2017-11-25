package com.bos.web.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.crm.domain.Customer;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.bos.bussiness.domain.Noticebill;
import com.bos.bussiness.domain.Staff;
import com.bos.bussiness.domain.User;
import com.bos.utils.PageBean;
import com.bos.web.action.base.BaseAction;



@Controller
@Scope("prototype")
public class NoticebillAction extends BaseAction<Noticebill>{

	
	public String findCustomerByTelephone() throws Exception {

		Customer customer = customerService.findCustomerByTelephone(model.getTelephone());
		
		
		this.objectToJson(customer, null, null );
		return NONE;
	}
	/*
	 * 保存业务通知单，尝试自动分单
	 */
	public String add (){
		model.setUser((User)ServletActionContext.getRequest().getSession().getAttribute("user"));
		noticebillService.save(model);
		return "add";
	}
	
	public String findnoassociations() throws IOException{
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Noticebill.class);
		criteria.add(Restrictions.eq("ordertype", "人工"));
		pageBean.setDetachedCriteria(criteria);
		noticebillService.pageQuery(pageBean);

		String [] excludes = new String [] {"user","currentPage","pageSize","staff","workbills"};
		this.objectToJson(pageBean, excludes , null);
		return NONE;
	}
	
	public String saveNoassociation(){
		noticebillService.savenoassociations(model);
		return "list";
	}
}
