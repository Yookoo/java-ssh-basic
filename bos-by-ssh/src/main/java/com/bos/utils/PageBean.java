package com.bos.utils;


import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

/**
 * 分页查询的Bean对象
 * @author ZKY
 * 
 */
@SuppressWarnings("rawtypes")
public class PageBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private int currentPage;//当前页
	private int pageSize;//每页显示的记录数
	private int total;//总页数
	private DetachedCriteria detachedCriteria;//查询条件对象

	private List rows;//结果集合
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public DetachedCriteria getDetachedCriteria() {
		return detachedCriteria;
	}
	public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
		this.detachedCriteria = detachedCriteria;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
	
}
