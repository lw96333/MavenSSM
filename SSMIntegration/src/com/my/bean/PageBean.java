package com.my.bean;

import java.io.Serializable;
import java.util.List;

/**
 * ��ҳ����
 * @author 49160
 *
 */
public class PageBean<E> implements Serializable{
	//��ǰҳ��
	private Integer pageNum;
	//������
	private Integer totalData;
	//ÿҳ��ʾ����
	private Integer pageSize;
	//��ʾ����
	private List<E> pageData;
	//��ҳ��
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
