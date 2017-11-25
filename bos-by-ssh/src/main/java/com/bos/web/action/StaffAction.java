package com.bos.web.action;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bos.bussiness.domain.Staff;
import com.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	


	public String pageQuery(){
		
		staffService.pageQuery(pageBean);
		String [] excludes = new String [] {"decidedzones","detachedCriteria"};
		this.objectToJson(pageBean, excludes,null);
		return NONE;
	}
	
	private String ids;
	public void setIds(String ids) {
		this.ids = ids;
	}
	@RequiresPermissions(value="staff")
	public String deleteStaff(){
		try {
			staffService.deleteStaff(ids);
		} catch (Exception e) {
			// 删除失败
		}	
		return NONE;
	}
	public String editStaff(){
		//如果是新增将staff的id置空
		if("".equals(model.getId())){
			model.setId(null);
		}		
		staffService.editStaff(model);
		return "list";
	}
	
	public String findStaffNotDelete(){
		
		List<Staff> list = staffService.findStaffNotDelete();
		
		String [] includes = new String [] {"id","name"};
		this.arrayListToJson(list,null,includes);
		
		return NONE;
	}
}
