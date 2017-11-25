package com.bos.web.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bos.bussiness.domain.Role;
import com.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ids;
	
	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getIds() {
		return ids;
	}

	public String add(){
		
		roleService.save(model,ids);
		return "list";
	}

	
	public String pageQuery(){
		
		roleService.pageQuery(pageBean);
		String [] excludes = new String [] {"functions","users","detachedCriteria"};
		this.objectToJson(pageBean, excludes,null);
		return NONE;	
	}
	
	public String findList(){
		List<Role> list = roleService.findList();
		String [] includes =new String [] {"id","name"};
		this.arrayListToJson(list, null,includes);
		return NONE;
	}
}
