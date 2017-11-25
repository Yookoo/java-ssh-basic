package com.young.action;

import java.io.IOException;
import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.young.po.Article;
import com.young.po.User;
import com.young.util.DateFormatUtils;
import com.young.util.JsonUtils;
import com.young.util.PageBean;

@Controller
@Scope("prototype")
public class ArticleAction extends BaseAction<Article>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3967284254913082120L;

	
	public String edit(){
		try {
			model.setJointime(DateFormatUtils.toyyyyMMddHHmmss(new Date()));
			User user = (User)ServletActionContext.getRequest().getSession().getAttribute("user");
			model.setUserId(user.getId());
			model.setClick(0);
			System.out.println("model.getcategoryId():"+ model.getCategoryId());;
			articleService.saveOrUpdate(model);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	

	
	public String findUserArticleByPage(){
		
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("user");
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Article.class);
		detachedCriteria.add(Restrictions.eq("userId", user.getId()));
		detachedCriteria.addOrder(Order.desc("jointime"));
		pageBean.setDetachedCriteria(detachedCriteria);
		articleService.pageQuery(pageBean);
		String[] excludes = {"detachedCriteria"};
		JsonUtils.objectToJson(pageBean, excludes , null);
		return NONE;
	}
	public String findAllArticleByPage(){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Article.class);
		detachedCriteria.addOrder(Order.desc("jointime"));
		pageBean.setDetachedCriteria(detachedCriteria);
		articleService.pageQuery(pageBean);
		String[] excludes = {"detachedCriteria"};
		JsonUtils.objectToJson(pageBean, excludes , null);
		return NONE;
	}
	public String findById(){
		Article article = articleService.findById(model.getId());
		ServletActionContext.getRequest().setAttribute("article", article);
		
		System.out.println("article"+ article);
		return "read";
	}
}
