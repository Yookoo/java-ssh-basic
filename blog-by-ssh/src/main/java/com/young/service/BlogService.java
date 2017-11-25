package com.young.service;

import java.io.Serializable;

import com.young.po.Blog;

public interface BlogService {

	Blog findById(Serializable id);

}
