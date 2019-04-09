package com.my.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象
 * @author 49160
 *
 */
public class PageBean<E> implements Serializable{
	//当前页面
	private Integer pageNum;
	//总条数
	private Integer totalData;
	//每页显示条数
	private Integer pageSize;
	//显示数据
	private List<E> pageData;
	//总页数
	private Integer totalNum;
	
	public PageBean() {}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getTotalData() {
		return totalData;
	}

	public void setTotalData(Integer totalData) {
		this.totalData = totalData;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<E> getPageData() {
		return pageData;
	}

	public void setPageData(List<E> pageData) {
		this.pageData = pageData;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	
	

}
