package com.java.bean;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
/**
 * 封装分页
 * @author 刘佳秋
 *
 * 2019年3月21日
 */
@Data
public class PageBean<E> implements Serializable{
	/**
	 * 当前页面
	 */
	private Integer pageNum;
	/**
	 * 总条数
	 */
	private Integer totalData;
	/**
	 * 每页显示条数
	 */
	private Integer pageSize;
	/**
	 * 显示数据
	 */
	private List<E> pageData;
	/**
	 * 总页数
	 */
	private Integer totalNum;
	
}
