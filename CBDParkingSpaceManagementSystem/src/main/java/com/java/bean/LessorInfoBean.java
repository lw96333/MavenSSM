package com.java.bean;

import lombok.Data;

/**
 * 预定车位人信息bean
 * @author 刘佳秋
 *
 * 2019年3月25日
 */
@Data
public class LessorInfoBean {

	/**
	 * 车位ID
	 */
	private int privatecarsid;
	/**
	 * 车位价格
	 */
	private int price;
	/**
	 * 租赁用户ID
	 */
	private int userid;
	/**
	 * 租借开始时间
	 */
	private String startime;
	/**
	 * 租借结束时间
	 */
	private String endtime;
	/**
	 * 留言信息
	 */
	private String message;
	/**
	 * 用户名
	 */
	private String name;
	/**
	 * 预定人工作
	 */
	private String job;
	/**
	 * 预定人电话
	 */
	private String phone;
	/**
	 * 车位发布时间
	 */
	private String issuetime;
	/**
	 * 投诉次数
	 */
	private String complaintnumber;
	/**
	 * 交易次数
	 */
	private String dealnumber;
}
