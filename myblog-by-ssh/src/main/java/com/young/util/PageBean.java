package com.young.util;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

/**
 * 分页的封装类
 * @author ZKY
 *
 */
public class PageBean <T>{

	private int currentPage = 1; //当前页数  
    private int totalCount;  //总记录数  
    private int totalPage;   //总页数  
    private int pageSize =10 ;    //每页显示的记录数  
    private List<T> list;    //每页显示数据记录的集合；
    
    private DetachedCriteria detachedCriteria;

	public PageBean() {
		
	}
    

	public int getCurrentPage() {
		return currentPage;
	}



	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}



	public int getTotalCount() {
		return totalCount;
	}



	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}



	public int getTotalPage() {
		return totalPage;
	}



	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}



	public int getPageSize() {
		return pageSize;
	}



	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}



	public List<T> getList() {
		return list;
	}



	public void setList(List<T> list) {
		this.list = list;
	}



	public DetachedCriteria getDetachedCriteria() {
		return detachedCriteria;
	}



	public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
		this.detachedCriteria = detachedCriteria;
	}





}