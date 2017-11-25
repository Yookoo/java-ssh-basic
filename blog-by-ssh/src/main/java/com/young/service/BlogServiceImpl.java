package com.young.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.young.dao.BaseDao;
import com.young.dao.BlogDao;
import com.young.po.Blog;
@Service
@Transactional
public class BlogServiceImpl implements BlogService{

	@Autowired
	private BlogDao blogDao;
	
	@Override
	public Blog findById(Serializable id) {
		return blogDao.findById(id);
	}

}
