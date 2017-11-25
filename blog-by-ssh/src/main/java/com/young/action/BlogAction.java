package com.young.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.young.po.Blog;
import com.young.po.User;
import com.young.util.JsonUtils;

@Controller
@Scope("prototype")
public class BlogAction extends BaseAction<Blog> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	public String findById() throws Exception {
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("user");
		Blog blog = blogService.findById(user.getId());
		
		String[] excludes = {"id","userId"};
		JsonUtils.objectToJson(blog, excludes  , null);
		return NONE;
	}
}
