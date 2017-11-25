package com.young.service;

import com.young.po.Article;
import com.young.util.PageBean;

public interface ArticleService {

	public void saveOrUpdate(Article artcle);


	public void pageQuery(PageBean<Article> pageBean);


	public Article findById(Integer id);
	

}