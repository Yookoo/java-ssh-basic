package com.young.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.young.dao.ArticleDao;
import com.young.po.Article;
import com.young.util.PageBean;

@Transactional
@Service
public class ArticleServiceImpl implements ArticleService{


	@Autowired
	private ArticleDao articleDao;
	@Override
	public void saveOrUpdate(Article artcle) {

		articleDao.saveOrUpdate(artcle);
	}
	@Override
	public void pageQuery(PageBean<Article> pageBean) {

		articleDao.pageQuery(pageBean);
		
	}
	@Override
	public Article findById(Integer id) {
		return articleDao.findById(id);	
	}


}
