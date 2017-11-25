package com.bos.web.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bos.bussiness.domain.Function;
import com.bos.web.action.base.BaseAction;

 /**
  *
  * show 这是用于响应"功能权限管理"的Action类，是BaseAction的子类；
  * 
  * @author ZKY
  * @category Controller类
  * @version v1.0
  */
@Controller
@Scope("prototype")
public class FunctionAction extends BaseAction<Function>{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 对于功能权限的分页查询方法
	 * @param 无
	 * @author ZKY
	 * @category 方法
	 * @return NONE
	 */
	public String pageQuery (){
		
		functionService.pageQuery(pageBean);
	
		String [] excludes = new String [] {"function","functions","roles","detachedCriteria"};
		 
		this.objectToJson(pageBean, excludes,null);
		return NONE;
	}
	
	/**
	 * 对于功能权限的查询方法
	 * @param 无
	 * @author ZKY
	 * @category 方法
	 * @return NONE
	 */
	public String getList(){
		List<Function> functions = functionService.findAll();
		
		String [] excludes = new String [] {"function","functions","roles"};		 
		this.arrayListToJson(functions, excludes,null);
		return NONE;
		
	}
	
	/**
	 * 对于功能权限的添加方法
	 * @param 无
	 * @author ZKY
	 * @category 方法
	 * @return String
	 */
	public String add(){
		functionService.save(model);
		return "list";
		
	}
	
	/**
	 * 菜单的查询方法
	 * @param 无
	 * @author ZKY
	 * @category 方法
	 * @return String
	 */
	public String findMenu(){
		List<Function> list = functionService.findMenu();
		String[] includes = new String[]{"id","name","pId","path"};
		this.arrayListToJson(list, null, includes );
		return NONE;
		
	}
}
