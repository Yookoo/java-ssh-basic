package com.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.bos.bussiness.domain.Staff;
import com.bos.bussiness.domain.Workordermanage;
import com.bos.utils.PageBean;
import com.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class WorkordermanageAction extends BaseAction<Workordermanage>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String add() throws IOException{
		
		String flag = "1";
		try{
			workordermanageService.save(model);
		}catch (Exception e) {
			e.printStackTrace();
			flag = "0";
		}
		ServletActionContext.getResponse().setContentType(
				"text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(flag);
		return NONE;
	}
	public String findWorkordermanage(){
		workordermanageService.findWorkordermanage(pageBean);		
		String [] includes = new String [] {"total","rows"};
		this.objectToJson(pageBean, null,includes);
		return NONE;
	}
}
